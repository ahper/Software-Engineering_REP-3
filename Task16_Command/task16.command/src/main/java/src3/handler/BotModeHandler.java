package src3.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public abstract class BotModeHandler {
    private BotModeHandler nextHandler;

    public BotModeHandler(BotModeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(String text, SendMessage sendMsg);

    public void setNextHandler() {
//        return nextHandler;
    }
}
