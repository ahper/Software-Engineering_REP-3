package src3;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src3.command.CancelCommand;
import src3.command.Command;
import src3.command.StartCommand;
import src3.handler.BotModeHandler;
import src3.mediator.Mediator;

import java.util.HashMap;

public class TelegramBot extends TelegramLongPollingBot implements Mediator {
    final private String BOT_NAME = "task16PI_bot";
    final private String BOT_TOKEN = "6291734371:AAHuq0WWRb9tR-WMkavQsTvrJUeaskgTYM0";
    private final HashMap<String, Command> commandMap = new HashMap();
    private final HashMap<Long, BotModeHandler> userChat = new HashMap<>();

    public TelegramBot() {
        commandMap.put("/start", new StartCommand(this));
        commandMap.put("/cancel", new CancelCommand(this));
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
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMsg = update.getMessage();
            String text = inMsg.getText();
//            Long chatID = inMsg.getChatId().toString();
            SendMessage sendMsg = new SendMessage();

            Command currentCommand = commandMap.get(text);
            if (currentCommand != null){
                BotModeHandler currentMode = currentCommand.execute(sendMsg);

                if (currentMode != null){
//                    currentMode.setNextHandler(commander);
//                    userChat.put(chatID, currentMode);
                } else {
//                    userChat.remove(chatID);
                }
            } else {
//                BotModeHandler currentMode = getCurrentMode(chatID);
//                currentMode.handle(text, sendMsg);
            }
            send(sendMsg);
        }
    }

    private void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BotModeHandler getCurrentMode(String chatID) {
        var isChatID = userChat.containsKey(chatID);
//        if (isChatID) c
        return null;
    }
}
