package src.command;

import src.handlers.BotMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
public abstract class Command {
    public abstract BotMode execute(SendMessage message);
}
