package src3.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src3.handler.BotModeHandler;
import src3.mediator.Mediator;

public abstract class Command {
    protected Mediator mediator;
    public Command(Mediator mediator) {this.mediator = mediator;}
    public abstract BotModeHandler execute(SendMessage message);
}
