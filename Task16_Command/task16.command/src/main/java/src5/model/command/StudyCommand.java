package src5.model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src5.model.mediator.Mediator;
import src5.model.sender.Sender;
import src5.model.sender.StudySender;

public class StudyCommand extends Command {
    private Mediator mediator;
    public StudyCommand(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public Sender execute(SendMessage sendMsg) {
        Sender studySender = new StudySender(mediator);
        studySender.onMessageReceived(sendMsg.getText());
        return studySender;
    }
}
