package src5.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    ArrayList<Question> questionsList = new ArrayList<>();

    public Storage() {
        String path = "C:/Users/ahtir/Desktop/ВУЗ/3 КУРС/2 СЕМЕСТР/МИНАКОВА/task16.command/task16.command/src/main/resources/questions.txt";
        try{
            load(path);
        } catch (Exception ex){ex.printStackTrace();}

    }
    public Storage(String filename) {load(filename);}

    private void load(String filename) {
        String temp;
        Question qtemp;
        FileReader fileReader;

        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        Scanner scanner = new Scanner(fileReader);
        scanner.useDelimiter("\\n");
        while (scanner.hasNextLine()) {
            qtemp = new Question();
            temp = scanner.nextLine();
            qtemp.setQuestion(temp);

            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#bad")){
                qtemp.addTrue(temp);
            }
            while(!(temp=scanner.nextLine()).equalsIgnoreCase("#vopros")){
                qtemp.addFalse(temp);
            }
            questionsList.add(qtemp);
        }
        System.out.println("файл считан" + questionsList.size());
    }

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }
}