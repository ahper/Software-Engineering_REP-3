package src2.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import src2.Mediator.BotModeService;

public class CommandStart implements Command {
    private final BotModeService botModeService;
    public final static String MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"
                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n");

    public CommandStart(BotModeService botModeService) {
        this.botModeService = botModeService;
    }

    @Override
    public void execute(Update update) {
        botModeService.sendMessage(update.getMessage().getChatId().toString(), MESSAGE);
    }

//    @Override
//    public BotModeService execute(SendMessage message) {
//        return botModeService.sendMessage(message.getChatId(), MESSAGE);
//    }
}
