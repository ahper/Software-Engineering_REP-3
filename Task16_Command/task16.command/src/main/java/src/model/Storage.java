package src.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    ArrayList<Question> questionsList = new ArrayList<>();
    public Storage() {
        load("questions.txt");
    }
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

    public ArrayList<Question> getAllQuestions(){return questionsList;}

//    public ArrayList<Question> generateRndQuests(int numberQuest){
//        ArrayList<Question> currentQuestion = new ArrayList<>();
//        ArrayList<Question> test1 = new ArrayList<>();
//        test1.addAll(questionsList);
//        for(int i = 0; i < numberQuest; i++){
//            int index;
//            index = (int)(Math.random()*test1.size());
//            if(index == test1.size())index --;
//            currentQuestion.add(test1.get(index));
//            test1.remove(index);
//        }
//        return currentQuestion;
//    }
}
