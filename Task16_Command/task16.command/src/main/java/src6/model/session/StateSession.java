package src6.model.session;

import src6.model.Question;

public interface StateSession {
    enum State {INIT, ACTION, CHECK, END, ERROR};
    public Question action();
    public boolean check(String answer);
    public String end();
    public State getState();
}
