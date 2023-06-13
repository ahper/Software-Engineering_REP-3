package src.command;

import src.handlers.BotMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.HashMap;


public class CommandStudy extends Command {
    HashMap<String, String> response = new HashMap<>();

    public CommandStudy(){
    }

    @Override
    public BotMode execute(SendMessage message) {
        return null;
    }
}
