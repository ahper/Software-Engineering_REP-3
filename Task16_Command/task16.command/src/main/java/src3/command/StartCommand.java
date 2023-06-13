package src3.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src3.handler.BotModeHandler;
import src3.mediator.Mediator;

public class StartCommand extends Command {
    BotModeHandler botModeHandler;
    public final static String START_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"
            + "%s /start - начать работу со мной\n");

    public StartCommand(Mediator mediator) {
        super(mediator);
    }

    @Override
    public BotModeHandler execute(SendMessage sendMsg) {
        botModeHandler.handle(START_MESSAGE, sendMsg);
        return botModeHandler;
    }
}
