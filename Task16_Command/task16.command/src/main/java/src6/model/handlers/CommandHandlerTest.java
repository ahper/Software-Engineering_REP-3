//package src6.model.handlers;
//
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import src6.model.command.Command;
//import src6.model.handlers.Handler;
//import src6.model.mediator.BotMediator;
//import src6.model.sender.Sender;
//
//import java.util.HashMap;
//
//public class CommandHandler implements Handler {
//    private HashMap<String, Command> commandMap = new HashMap<>();
//    private Handler nextHandler;
//    private BotMediator botMediator;
//
//    public CommandHandler() {
//        botMediator = new BotMediator();
//    }
//
//    // Регистрация команды
//    public void registerCommand(String command, Command commandObject) {
//        commandMap.put(command, commandObject);
//    }
//
//    // Установка следующего обработчика
//    public void setNext(Handler nextHandler) {
//        this.nextHandler = nextHandler;
//    }
//
//    // Обработка команды
//    public void handleCommand(String command, Long chatID, SendMessage sendMsg) {
//        if (commandMap.containsKey(command)) {
//            Command currentCommand = commandMap.get(command);
//            Sender stateSession = currentCommand.execute(sendMsg);
//            botMediator.addUserChat(chatID, stateSession);
//        } else if (nextHandler != null) {
//            nextHandler.handleCommand(command, chatID, sendMsg);
//        } else {
//            sendMsg.setText("Ошибочная команда!");
//        }
//    }
//}
