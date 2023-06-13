package src3.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class StartHandler extends BotModeHandler {
    public StartHandler(BotModeHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(String text, SendMessage sendMsg) {
        sendMsg.enableHtml(true);
        sendMsg.setText(text);
    }
}
