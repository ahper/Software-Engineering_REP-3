package src.command;

import src.handlers.BotMode;
import src.model.Examinator;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class CommandExam extends Command {
    Examinator examinator = new Examinator();
    @Override
    public BotMode execute(SendMessage sendMsg) {
        var listQuestions = examinator.generateQuestions(3);
        for (var qw : listQuestions){
            sendMsg.setText(examinator.askQuestion(qw));
        }
        return null;
    }
}
