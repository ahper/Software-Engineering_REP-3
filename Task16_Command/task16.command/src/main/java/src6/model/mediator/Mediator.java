package src6.model.mediator;

import src6.model.sender.Sender;

public interface Mediator {
    void notify(Sender sender, String message);
}