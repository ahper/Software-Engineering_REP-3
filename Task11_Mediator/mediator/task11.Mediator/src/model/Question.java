package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;

public class Question {
    StringProperty question;
    ArrayList<StringProperty> answerGood;
    ArrayList<StringProperty> answerBad;
    Integer type;

    public Question(String qw){
        question = new SimpleStringProperty(qw);
        answerGood= new ArrayList<>();
        answerBad= new ArrayList<>();
    }

    public int addTrue(String s){
        answerGood.add(new SimpleStringProperty(s));
        return answerGood.size();
    }

    public int addFalse(String s){
        answerBad.add(new SimpleStringProperty(s));
        return answerBad.size();
    }

    public void SetQuest(String s){
        question = new SimpleStringProperty(s);
    }

    public ArrayList<StringProperty> getAnswerGood() {
        return answerGood;
    }

    public ArrayList<StringProperty> getBadAnswer() {
        return answerBad;
    }

    public String getQuestion() {
        return question.get();
    }

    public StringProperty questionProperty() {
        return question;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public void setAnswerGood(ArrayList<StringProperty> answerGood) {
        this.answerGood = answerGood;
    }

    public void setBadAnswer(ArrayList<StringProperty> answerBad) {
        this.answerBad = answerBad;
    }
}
