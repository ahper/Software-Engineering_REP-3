package src2.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import src2.Mediator.BotModeService;

public interface Command {
    void execute(Update update);
//    BotModeService execute(SendMessage message);
}
