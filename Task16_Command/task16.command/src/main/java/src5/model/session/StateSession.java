package src5.model.session;

import src5.model.Question;

public interface StateSession {
    enum State {INIT, ACTION, CHECK, END, ERROR};
    public Question action();
    public boolean check(String answer);
    public String end();
    public State getState();
}
