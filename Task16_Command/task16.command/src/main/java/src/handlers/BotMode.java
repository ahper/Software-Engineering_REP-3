package src.handlers;

import src.command.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public abstract class BotMode {
    private BotMode nextHandler;
    public BotMode(BotMode nextHandler) {
        this.nextHandler = nextHandler;
    }
    public void handle(String text, SendMessage sendMsg) {

    }
    public BotMode setNextHandler(Command commander) {
        return commander.execute(new SendMessage());
    }
}
