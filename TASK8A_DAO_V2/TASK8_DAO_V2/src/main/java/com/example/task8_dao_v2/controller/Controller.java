package com.example.task8_dao_v2.controller;

import com.example.task8_dao_v2.DAO.TaskDAO;
import com.example.task8_dao_v2.model.Task;
import com.example.task8_dao_v2.model.TaskFabrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.task8_dao_v2.model.TaskFabrica.createTaskDAO;

public class Controller implements Initializable {
    public TableView myTable;
//    private DbTaskDAO impl;
    TaskDAO taskDAO;
    @FXML Button btnAdd, btnDell, btnRefresh, btnSearch;
    @FXML TextField tfAddName, tfAddTime, tfAddStatus,
            tfDellId,
            tfRefreshId, tfRefreshName, tfRefreshTime, tfRefreshStatus,
            tfSearchId;
    @FXML ComboBox comboBoxState;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createColumns();
        comboBoxStateInit();
    }

    private void comboBoxStateInit(){
        ObservableList<String> items = FXCollections.observableArrayList(
                TaskFabrica.BD, TaskFabrica.FILE, TaskFabrica.RAM);
        comboBoxState.setItems(items);
        comboBoxState.setOnAction(e -> {
            taskDAO = createTaskDAO(comboBoxState.getValue().toString());
            myTable.setItems(FXCollections.observableList(taskDAO.getAllTasks()));
        });
    }

    private void createColumns() {
        TableColumn column0 = new TableColumn("Номер");
        column0.setMinWidth(15);
        column0.setCellValueFactory(new PropertyValueFactory<Task, Integer>("id"));

        TableColumn column1 = new TableColumn("Название");
        column1.setMinWidth(100);
        column1.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));

        TableColumn column2 = new TableColumn("Время");
        column2.setMinWidth(50);
        column2.setCellValueFactory(new PropertyValueFactory<Task, String>("time"));

        TableColumn column3 = new TableColumn("Статус");
        column3.setMinWidth(100);
        column3.setCellValueFactory(new PropertyValueFactory<Task, String>("status"));

        myTable.getColumns().addAll(column0, column1, column2, column3);
    }

    public void OnBtnAdd(ActionEvent actionEvent) {
        try{
            String name = tfAddName.getText();
            String time = tfAddTime.getText();
            String status = tfAddStatus.getText();

            taskDAO.addTask(new Task(0, name, time, status));
            myTable.setItems(FXCollections.observableList(taskDAO.getAllTasks()));
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void OnBtnRefresh(ActionEvent actionEvent) {
        try{
            int id = Integer.parseInt(tfRefreshId.getText());
            String name = tfRefreshName.getText();
            String time = tfRefreshTime.getText();
            String status = tfRefreshStatus.getText();

            Task newTask = new Task(id, name, time, status);
            taskDAO.updateTask(newTask);
            myTable.setItems(FXCollections.observableList(taskDAO.getAllTasks()));
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void OnBtnDell(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(tfDellId.getText());
            taskDAO.deleteTask(id);
            myTable.setItems(FXCollections.observableList(taskDAO.getAllTasks()));
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void OnBtnSearch(ActionEvent actionEvent) {
        ArrayList<Task> findTask = new ArrayList<>();
        try {
            int id = Integer.parseInt(tfSearchId.getText());
            if (taskDAO.getTaskById(id).getId() == id){
                findTask.add(taskDAO.getTaskById(id));
                myTable.setItems(FXCollections.observableList(findTask));
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}
