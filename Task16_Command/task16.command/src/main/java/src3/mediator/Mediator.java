package src3.mediator;

import src3.handler.BotModeHandler;

public interface Mediator {
    BotModeHandler getCurrentMode(String chatId);
}
