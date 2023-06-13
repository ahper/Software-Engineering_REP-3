package src5.model.session;

import src5.model.Examinator;
import src5.model.Question;

public class ExamSession implements StateSession {
    State stateSession;
    Examinator examinator;

    public ExamSession() {
        stateSession = State.INIT;
        examinator = new Examinator();
    }
    @Override
    public Question action() {
        stateSession = State.ACTION;
        return examinator.action();
    }

    @Override
    public boolean check(String answer) {
        if (stateSession == State.ACTION) {
            boolean isCorrect = examinator.check(answer);
            if (examinator.isExamFinished()) {
                stateSession = State.END;
            }
            return isCorrect;
        }
        return false;
    }

    @Override
    public String end() {
        if (stateSession == State.END) {
            return examinator.end();
        }
        return null;
    }

    @Override
    public State getState() {
        return stateSession;
    }
}
