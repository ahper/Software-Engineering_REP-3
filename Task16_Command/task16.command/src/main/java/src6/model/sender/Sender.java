package src6.model.sender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src6.model.mediator.Mediator;
import src6.model.session.StateSession;

public abstract class Sender {
    protected StateSession stateSession;
    protected final Mediator mediator;

    public Sender(Mediator mediator) {
        this.mediator = mediator;
    }

    /** Получить сообщение */
    public abstract void onMessageReceived(String message);

    /** Отправить сообщение */
    public abstract SendMessage createSendMessage();
}
