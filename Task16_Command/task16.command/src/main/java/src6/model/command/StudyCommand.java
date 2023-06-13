package src6.model.command;//package src5.model.command;
//
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import src5.model.sender.Sender;
//import src5.model.sender.StudySender;
//
//public class StudyCommand extends Command {
//    @Override
//    public Sender execute(SendMessage sendMsg) {
//        Sender studySender = new StudySender();
//        studySender.onMessageReceived(sendMsg.getText());
//        return studySender;
//    }
//}
