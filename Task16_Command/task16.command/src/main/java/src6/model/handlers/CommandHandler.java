package src6.model.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import src6.model.sender.Sender;

public abstract class CommandHandler {
    protected CommandHandler nextHandler;
    protected CommandHandler modeHandler;

    public void setNext(CommandHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void setModeHandler(CommandHandler modeHandler) {
        this.modeHandler = modeHandler;
    }

    public abstract void handle(Message message, Sender sender);
}
