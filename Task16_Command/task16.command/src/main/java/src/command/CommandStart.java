package src.command;

import src.handlers.BotMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class CommandStart extends Command {
    @Override
    public BotMode execute(SendMessage message) {
        return null;
    }
}
