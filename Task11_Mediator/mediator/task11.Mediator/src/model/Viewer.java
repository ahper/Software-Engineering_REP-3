package model;

import model.interafce.Mediator;

import javafx.scene.control.TextArea;
import java.util.ArrayList;

public class Viewer extends Colleague{
    final int NUMBER=10;
    public Viewer(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notifyColleague(ArrayList<Question> test) {
        TextArea textArea = new TextArea();
        String str="";
        for (int i = 0; i < test.size(); i++) {
            str+=""+(i+1)+" "+test.get(i).getQuestion()+"\n\r";
            for (int j = 0; j < test.get(i).getAnswerGood().size(); j++) {
                str+=test.get(i).getAnswerGood().get(j).getValue()+"\n";
            }
            str+="НЕ ПРАВИЛЬНО"+"\n\r";
            for (int j = 0; j < test.get(i).getBadAnswer().size(); j++) {
                str+=(test.get(i).getBadAnswer().get(j)).getValue()+"\r\n";
            }
        }
        textArea.setText(str);
        textArea.setWrapText(true);
        mediator.setView(textArea);
    }

    public void receive(ArrayList<Question> message){
        ArrayList<Question> currentTest = new ArrayList<>();
        ArrayList<Question> test=new ArrayList<>();
        test.addAll(message);
        for(int i = 0; i<NUMBER && i<test.size(); i++){
            int index;
            index = (int)(Math.random()*test.size());
            if(index == test.size())index --;
            currentTest.add(test.get(index));
            test.remove(index);
        }
        super.receive(currentTest);
    }

}
