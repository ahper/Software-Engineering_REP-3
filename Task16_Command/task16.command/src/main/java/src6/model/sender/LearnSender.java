package src6.model.sender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src6.model.Question;
import src6.model.mediator.Mediator;
import src6.model.session.LearnSession;
import src6.model.session.StateSession;

public class LearnSender extends Sender {
    public LearnSender(Mediator mediator) {
        super(mediator);
        stateSession = new LearnSession();
    }

//    public LearnSender() {
//        stateSession = new LearnSession();
//    }

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
