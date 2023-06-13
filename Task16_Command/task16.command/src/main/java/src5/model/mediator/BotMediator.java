package src5.model.mediator;

import src5.model.sender.Sender;

import java.util.HashMap;

public class BotMediator implements Mediator {
    private HashMap<Long, Sender> userChat = new HashMap<>();

    public void addUserChat(long chatID, Sender sender) {
        userChat.put(chatID, sender);
    }

    public Sender getUserChat(long chatID) {
        return userChat.get(chatID);
    }

    @Override
    public void notify(Sender sender, String message) {
        sender.onMessageReceived(message);
    }
}
