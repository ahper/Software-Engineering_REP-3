package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.*;
import model.interafce.Mediator;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable, Mediator {
    private HashMap<String, Colleague> id = new HashMap<>();
    private Colleague currentColleague;
//    private BaseTest baseTest = new BaseTest("test.txt");
    private BaseTest baseTest = new BaseTest("C:/Users/ahtir/Desktop/ВУЗ/3 КУРС/2 СЕМЕСТР/МИНАКОВА/mediator/mediator/task11.Mediator/test.txt");
    @FXML public ScrollPane viewpane;
    @FXML public TextField login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.put("editor", new Editor(this));
        id.put("viewer", new Viewer(this));
        id.put("student", new Worker(this));
    }

    public void onStart(ActionEvent actionEvent) {
        currentColleague = id.get(login.getText());
        if(currentColleague == null) currentColleague = id.get("viewer");
        currentColleague.receive(baseTest.getTest());
        currentColleague.notifyColleague(currentColleague.getReceivedMessage());
    }

    @Override
    public void setView(Node control) {
        Group root = new Group();
        ScrollBar sc = new ScrollBar();
        sc.setLayoutX(control.getLayoutX());
        control.setLayoutX(control.getLayoutX()+sc.getWidth());
        sc.setMin(0);
        sc.setValue(50);
        sc.setMax(100);
        sc.setOrientation(Orientation.VERTICAL);
        root.getChildren().addAll(control,sc);
        viewpane.setContent(control);
    }
}
