package model;

import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.interafce.Mediator;

import java.util.ArrayList;

public class Editor extends Colleague{
    public Editor(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notifyColleague(ArrayList<Question> message) {
        VBox qwpane = new VBox();
        for (int x = 0; x < message.size(); x++)
        {
            TextField qwfield = new TextField();
            qwfield.textProperty().bindBidirectional(message.get(x).questionProperty());
            qwpane.getChildren().add(qwfield);
            Separator separator=new Separator();
            separator.setMaxWidth(20);
            qwpane.getChildren().add(separator);
            for (int i = 0; i <message.get(x).getAnswerGood().size() ; i++) {
                TextField qwfieldi=new TextField();
                qwfieldi.textProperty().bindBidirectional(message.get(x).getAnswerGood().get(i));
                qwpane.getChildren().add(qwfieldi);
            }
            Separator separator2 = new Separator();
            separator2.setMaxWidth(40);
            qwpane.getChildren().add(separator2);
            for (int i = 0; i <message.get(x).getBadAnswer().size() ; i++) {
                TextField qwfieldi = new TextField();
                qwfieldi.textProperty().bindBidirectional(message.get(x).getBadAnswer().get(i));
                qwpane.getChildren().add(qwfieldi);
            }
        }
        mediator.setView(qwpane);
    }
}
