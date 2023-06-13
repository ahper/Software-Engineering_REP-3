package src6.model.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import src6.model.command.Command;
import src6.model.command.LearnCommand;
import src6.model.sender.Sender;

public class ModeCommandHandler extends CommandHandler {
    private String mode;

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public void handle(Message message, Sender sender) {
        if (mode != null) {
            // Вызываем action() режима
            // ...
        } else if (nextHandler != null) {
            nextHandler.handle(message, sender);
        }
    }
}
