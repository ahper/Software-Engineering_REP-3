package src6;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src6.model.handlers.CommandHandler;
import src6.model.handlers.ModeCommandHandler;
import src6.model.handlers.command.LearnCommandHandler;
import src6.model.mediator.BotMediator;
import src6.model.sender.Sender;

public class TelegramBot extends TelegramLongPollingBot {
    private final String BOT_NAME = "task16PI_bot";
    private final String BOT_TOKEN = "6291734371:AAHuq0WWRb9tR-WMkavQsTvrJUeaskgTYM0";
    private final BotMediator botMediator;
    private final CommandHandler commandHandler;
    private final ModeCommandHandler modeCommandHandler;

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

        modeCommandHandler = new ModeCommandHandler();
        commandHandler = modeCommandHandler;

        // Создание обработчиков команд
        CommandHandler learnHandler = new LearnCommandHandler(botMediator);
//        CommandHandler examHandler = new ExamCommandHandler(botMediator);
//        CommandHandler studyHandler = new StudyCommandHandler(botMediator);

        // Установка цепочки обработчиков команд
        modeCommandHandler.setNext(learnHandler);
//        learnHandler.setNext(examHandler);
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message msg = update.getMessage();
            String text = msg.getText();
            Long chatID = msg.getChatId();
            SendMessage sendMsg = new SendMessage();

            if (text.startsWith("/")) {
                String command = text.toLowerCase();
                if (command.equals("/cancel")) {
                    botMediator.removeUserChat(chatID);
                    sendMsg.setText("Главное меню");
                } else {
                    // Обработка команды выбора режима
                    modeCommandHandler.setMode(command);
                    sendMsg.setText("Выбран режим: " + command);
                }
            } else {
                // Обработка обычного сообщения
                Sender stateSession = botMediator.getUserChat(chatID);
                if (stateSession != null) {
                    commandHandler.handle(msg, stateSession);
                    sendMsg = stateSession.createSendMessage();
                } else {
                    sendMsg.setText("Выберите команду!");
                }
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

