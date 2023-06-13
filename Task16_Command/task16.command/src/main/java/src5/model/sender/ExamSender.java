package src5.model.sender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src5.model.Question;
import src5.model.mediator.Mediator;
import src5.model.session.ExamSession;
import src5.model.session.StateSession;

public class ExamSender extends Sender {
    public ExamSender(Mediator mediator) {
        super(mediator);
        stateSession = new ExamSession();
    }

    @Override
    public void onMessageReceived(String message) {
        stateSession.check(message);
    }

    @Override
    public SendMessage createSendMessage() {
        SendMessage sendMsg = new SendMessage();

        if (stateSession.getState() == StateSession.State.ACTION ||
                stateSession.getState() == StateSession.State.INIT) {
            Question qt = stateSession.action();
            sendMsg.setText(qt.getQuestion() + "?");
        }
        else { sendMsg.setText("" + stateSession.end()); }
        return sendMsg;
    }
}
