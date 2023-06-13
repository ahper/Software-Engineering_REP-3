package src5.model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src5.model.mediator.Mediator;
import src5.model.sender.LearnSender;
import src5.model.sender.Sender;

public class LearnCommand extends Command {
    private Mediator mediator;

    public LearnCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public Sender execute(SendMessage sendMsg) {
        Sender learnSender = new LearnSender(mediator);
        learnSender.onMessageReceived(sendMsg.getText());
        return learnSender;
    }
}
