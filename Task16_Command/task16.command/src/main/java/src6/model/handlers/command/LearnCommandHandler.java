package src6.model.handlers.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import src6.model.handlers.CommandHandler;
import src6.model.mediator.BotMediator;
import src6.model.sender.LearnSender;
import src6.model.sender.Sender;

public class LearnCommandHandler extends CommandHandler {
    private BotMediator botMediator;

    public LearnCommandHandler(BotMediator botMediator) {
        this.botMediator = botMediator;
    }

    @Override
    public void handle(Message message, Sender sender) {
        String command = message.getText();
        if (command.equals("/learn")) {
            // Логика обработки команды "/learn"
            Sender learnSender = new LearnSender(botMediator);
            botMediator.addUserChat(message.getChatId(), learnSender);
        } else if (nextHandler != null) {
            nextHandler.handle(message, sender);
        }
    }
}
