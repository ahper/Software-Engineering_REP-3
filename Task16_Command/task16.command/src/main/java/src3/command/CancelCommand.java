package src3.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src3.handler.BotModeHandler;
import src3.mediator.Mediator;

public class CancelCommand extends Command {
    public CancelCommand(Mediator mediator) {
        super(mediator);
    }

    @Override
    public BotModeHandler execute(SendMessage message) {
        return null;
    }
}
