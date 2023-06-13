package com.example.task8_dao_v2.model;

import com.example.task8_dao_v2.DAO.DbTaskDAO;
import com.example.task8_dao_v2.DAO.FileTaskDAO;
import com.example.task8_dao_v2.DAO.ListTaskDAO;
import com.example.task8_dao_v2.DAO.TaskDAO;

public class TaskFabrica {
    public static String BD = "DataBase";
    public static String FILE = "FILE";
    public static String RAM = "LIST";

    public static TaskDAO createTaskDAO(String type) {
        if (type.equalsIgnoreCase(BD)) {
            return new DbTaskDAO();
        } else if (type.equalsIgnoreCase(FILE)) {
            return new FileTaskDAO("C:/Users/ahtir/Desktop/ВУЗ/3 КУРС/2 СЕМЕСТР/МИНАКОВА/TASK8_DAO_V2/TASK8_DAO_V2/src/main/resources/com/example/task8_dao_v2/tasks.txt");//имя файла
        } else if (type.equalsIgnoreCase(RAM)) {
            return new ListTaskDAO(10);
        } else {
            throw new IllegalArgumentException("Invalid datasource type!");
        }
    }
}