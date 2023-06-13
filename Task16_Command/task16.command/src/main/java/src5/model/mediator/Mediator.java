package src5.model.mediator;

import src5.model.sender.Sender;

public interface Mediator {
    void notify(Sender sender, String message);
}