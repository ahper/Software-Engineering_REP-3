package src2.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import src2.Mediator.BotModeService;

public class CommandUnknown implements Command {
    private final BotModeService botModeService;
    public final static String MESSAGE = "Команда не распознана!";

    public CommandUnknown(BotModeService botModeService) {
        this.botModeService = botModeService;
    }

    @Override
    public void execute(Update update) {
        botModeService.sendMessage(update.getMessage().getChatId().toString(), MESSAGE);
    }
}
