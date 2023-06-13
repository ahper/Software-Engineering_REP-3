package model;

import model.interafce.Mediator;

import java.util.ArrayList;

public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void notifyColleague(ArrayList<Question> message);
    protected ArrayList<Question> receivedMessage;
    public void receive(ArrayList<Question> message){
        this.receivedMessage=message;
    }
    public ArrayList<Question> getReceivedMessage() {
        return this.receivedMessage;
    }
}
