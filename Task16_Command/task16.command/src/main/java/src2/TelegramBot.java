package src2;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import src2.Mediator.BotModeServiceImpl;
import src2.command.CommandContainer;

public class TelegramBot extends TelegramLongPollingBot {
    final private String BOT_TOKEN = "6291734371:AAHuq0WWRb9tR-WMkavQsTvrJUeaskgTYM0";
    final private String BOT_NAME = "task16PI_bot";
    private final CommandContainer commandContainer;

    public TelegramBot() {
        this.commandContainer = new CommandContainer(new BotModeServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith("/")) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.getCommand(commandIdentifier).execute(update);
            } else {
//                commandContainer.getCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
