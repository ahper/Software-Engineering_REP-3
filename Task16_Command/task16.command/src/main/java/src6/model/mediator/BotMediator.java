package src6.model.mediator;

import src6.model.sender.Sender;

import java.util.HashMap;

public class BotMediator implements Mediator {
    private HashMap<Long, Sender> userChat = new HashMap<>();
    public void addUserChat(long chatID, Sender sender) {
        userChat.put(chatID, sender);
    }
    public Sender getUserChat(long chatID) {
        return userChat.get(chatID);
    }
    public void removeUserChat(Long chatID) { userChat.remove(chatID);}
    @Override
    public void notify(Sender sender, String message) {
        sender.onMessageReceived(message);
    }
}
