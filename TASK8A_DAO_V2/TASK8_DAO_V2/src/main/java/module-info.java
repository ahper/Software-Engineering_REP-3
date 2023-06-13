module com.example.task8_dao_v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.task8_dao_v2 to javafx.fxml;
    exports com.example.task8_dao_v2;
    exports com.example.task8_dao_v2.DAO;
    opens com.example.task8_dao_v2.DAO to javafx.fxml;
    exports com.example.task8_dao_v2.main;
    opens com.example.task8_dao_v2.main to javafx.fxml;
    exports com.example.task8_dao_v2.controller;
    opens com.example.task8_dao_v2.controller to javafx.fxml;
    exports com.example.task8_dao_v2.model;
    opens com.example.task8_dao_v2.model to javafx.fxml;
}