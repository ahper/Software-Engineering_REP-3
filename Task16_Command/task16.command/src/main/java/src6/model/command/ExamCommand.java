//package src6.model.command;
//
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import src6.model.mediator.Mediator;
//import src6.model.sender.ExamSender;
//import src6.model.sender.Sender;
//
//public class ExamCommand extends Command {
//    private Mediator mediator;
//    public ExamCommand(Mediator mediator) {this.mediator = mediator;}
//    @Override
//    public Sender execute(SendMessage sendMsg) {
//        Sender examSender = new ExamSender(mediator);
//        examSender.onMessageReceived(sendMsg.getText());
//        return examSender;
//    }
//}
