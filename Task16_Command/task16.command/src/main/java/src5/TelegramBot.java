package src5;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src5.model.command.Command;
import src5.model.command.ExamCommand;
import src5.model.command.LearnCommand;
import src5.model.command.StudyCommand;
import src5.model.mediator.BotMediator;
import src5.model.sender.Sender;

import java.util.HashMap;

public class TelegramBot extends TelegramLongPollingBot {
    final private String BOT_NAME = "task16PI_bot";
    final private String BOT_TOKEN = "6291734371:AAHuq0WWRb9tR-WMkavQsTvrJUeaskgTYM0";
    private final BotMediator botMediator;
    private final HashMap<String, Command> commandMap = new HashMap<>();

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public TelegramBot() {
        botMediator = new BotMediator();
        commandMap.put("/learn", new LearnCommand(botMediator));
        commandMap.put("/exam", new ExamCommand(botMediator));
        commandMap.put("/study", new StudyCommand(botMediator));
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMsg = update.getMessage();
            String text = inMsg.getText();
            Long chatID = inMsg.getChatId();
            SendMessage sendMsg = new SendMessage();

            // Определение текущего режима бота
            if (text.startsWith("/")) {
                Command currentCommand = commandMap.get(text);
                if (currentCommand != null) {
                    Sender stateSession = currentCommand.execute(sendMsg);
                    botMediator.addUserChat(chatID, stateSession);
                    sendMsg = stateSession.createSendMessage();
                } else {sendMsg.setText("Ошибочная команда!");}
            } else {
                Sender stateSession = botMediator.getUserChat(chatID);
                if(stateSession != null){
                    botMediator.notify(stateSession, text);
                    sendMsg = stateSession.createSendMessage();
                } else {sendMsg.setText("Выберите команду!");}
            }
            sendMsg.setChatId(chatID.toString());
            try {
                execute(sendMsg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

