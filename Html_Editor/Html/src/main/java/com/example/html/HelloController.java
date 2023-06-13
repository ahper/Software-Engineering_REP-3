package com.example.html;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import com.example.html.test.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloController {
    public VBox box;
    public HTMLEditor editor;
    public WebView web;
    public TextArea textAr;

    //выбор файла
    public void onOpen(ActionEvent actionEvent) throws FileNotFoundException
    {
        Test test1 = new Test();
        test1.testMethod();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Document");
        FileChooser.ExtensionFilter extFilter = new
                FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(box.getScene().getWindow());
        web.getEngine().load(file.toURI().toString());
        load(file);
    }

    //загрузка из выбранного файла
    private void load(File file){
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                textAr.appendText(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        editor.setHtmlText(textAr.getText());
        web.getEngine().loadContent(editor.getHtmlText());
    }

    //внесение изменений в редакторе
    public void onChange(ActionEvent actionEvent) {
        textAr.setText(editor.getHtmlText());
        web.getEngine().loadContent(editor.getHtmlText());
    }
}
