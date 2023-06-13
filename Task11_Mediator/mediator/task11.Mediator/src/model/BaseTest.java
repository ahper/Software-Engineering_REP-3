package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseTest {
    ArrayList<Question> test = new ArrayList<>();

    public BaseTest() {
        load("test.txt");
    }

    public BaseTest(String filename) {
        load(filename);
    }

    public ArrayList<Question> createTest(int numberQuest){
        ArrayList<Question> currentTest = new ArrayList<>();
        ArrayList<Question> test1 = new ArrayList<>();
        test1.addAll(test);
        for(int i = 0; i< numberQuest; i++){
            int index;
            index = (int)(Math.random()*test1.size());
            if(index == test1.size())index --;
            currentTest.add(test1.get(index));
            test1.remove(index);
        }
        return currentTest;
    }

    public ArrayList<Question> getTest() {
        return test;
    }

    private void load(String filename) {
        String temp;
        Question qtemp;
        FileReader fin;

        // Объявляем класс Scanner, инициализируем его с параметром file
        // Создаем цикл, который будет считывать строки, пока не дойдем
        // до конца файла.
        try {
            fin = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;

        }
        Scanner scanner = new Scanner(fin);
        scanner.useDelimiter("\\n");
        while (scanner.hasNextLine()) {
            qtemp = new Question("");
            temp = scanner.nextLine();
            qtemp.SetQuest(temp);

            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#bad")){
                qtemp.addTrue(temp);
            }

            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#vopros")){
                qtemp.addFalse(temp);
            }

            test.add(qtemp);
        }
        System.out.println("файл считан"+test.size());
    }

    public void setTest(ArrayList<Question> test) {
        this.test = test;
    }
}
