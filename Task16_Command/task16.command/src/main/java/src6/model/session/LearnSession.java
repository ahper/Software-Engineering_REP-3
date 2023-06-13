package src6.model.session;

import src6.model.Leaner;
import src6.model.Question;

public class LearnSession implements StateSession {
    State stateSession;
    Leaner leaner;

    public LearnSession() {
        stateSession = State.INIT;
        leaner = new Leaner();
    }

    @Override
    public Question action() {
        stateSession = State.ACTION;
        return leaner.action();
    }

    @Override
    public boolean check(String answer) {
        if (stateSession == State.ACTION) {
            boolean isCorrect = leaner.check(answer);
            if (isCorrect) {
                stateSession = State.END;
            }
            return isCorrect;
        }
        return false;
    }

    @Override
    public String end() {
        if (stateSession == State.END) {
            return leaner.end();
        }
        return "Test end.";
    }

    @Override
    public State getState() {
        return stateSession;
    }
}
