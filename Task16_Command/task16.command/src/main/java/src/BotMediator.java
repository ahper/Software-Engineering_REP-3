package src;

import src.command.*;
import src.handlers.BotMode;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src.model.Question;

import java.util.ArrayList;
import java.util.HashMap;

public class BotMediator extends TelegramLongPollingBot {
    final private String BOT_TOKEN = "6291734371:AAHuq0WWRb9tR-WMkavQsTvrJUeaskgTYM0";
    final private String BOT_NAME = "task16PI_bot";
//    Storage storage; // Из Storage получаем сообщение (БАНК ВОПРОСОВ)
    Command commander;
    HashMap<String, Command> command = new HashMap();
    HashMap<String, BotMode> userChat = new HashMap();

    public BotMediator() {
//        storage = new Storage();
        command.put("/start", new CommandStart());
        command.put("/exam", new CommandExam());
        command.put("/study", new CommandStudy());
        command.put("/learn", new CommandLearn());
        command.put("/cancel", new CommandCancel());
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();

                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();

                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                var response = command.get(inMess.getText());

                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage sendMsg = new SendMessage();
                sendQuestion(sendMsg);

                //Добавляем в наше сообщение id чата а также наш ответ
                sendMsg.setChatId(chatId);
                sendMsg.setText("");

                //Отправка в чат
                execute(sendMsg);




                Command comn = command.get(inMess.getText());
                if(comn != null) {
                    BotMode currentMode = comn.execute(sendMsg);
                    if(currentMode != null) {
                        currentMode.setNextHandler(commander);
                        userChat.put(chatId, currentMode);
                    }
                    else {
                        userChat.remove(chatId);
                    }
                }
                else {
                    BotMode currentMode = getCurrentMode(chatId);
                    currentMode.handle(inMess.getText(), sendMsg);
                }
                sendMessage(sendMsg);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private BotMode getCurrentMode(String chatId) {
        BotMode currentMode = userChat.get(chatId);
        return currentMode;
    }

    // Ответ пользователю
    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // Кнопки ответа для пользователя
    private void sendQuestion(SendMessage message) {
        message.setParseMode("HTML");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        // создаем кнопки для ответа на сообщение
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("123");
        keyboard.add(keyboardRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        message.setReplyMarkup(replyKeyboardMarkup);
    }

//    private void sendQuestion2(SendMessage message, Question question) {
//        message.setParseMode("HTML");
//        message.setText(question.getQuestion());
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//
//        // создаем кнопки для ответа на сообщение
//        ArrayList<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
//        for (String s : question.generateAnswer()) {
//            KeyboardRow keyboardRowtest = new KeyboardRow();
//            keyboardRowtest.add(s);
//            keyboard.add(keyboardRowtest);
//        }
//        replyKeyboardMarkup.setKeyboard(keyboard);
//        replyKeyboardMarkup.setOneTimeKeyboard(true);
//        message.setReplyMarkup(replyKeyboardMarkup);
//    }
}
