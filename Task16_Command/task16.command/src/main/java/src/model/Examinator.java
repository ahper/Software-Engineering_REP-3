package src.model;

import java.util.ArrayList;

public class Examinator {

    // Генерирует count вопросов из списка вопросов
    public ArrayList<Question> generateQuestions(int count) {
        Storage storage = new Storage();
        ArrayList<Question> currentQuestion = new ArrayList<>();
        ArrayList<Question> test1 = new ArrayList<>();
        test1.addAll(storage.getAllQuestions());
        for(int i = 0; i < count; i++){
            int index;
            index = (int)(Math.random()*test1.size());
            if(index == test1.size())index --;
            currentQuestion.add(test1.get(index));
            test1.remove(index);
        }
        return currentQuestion;
    }

    // Задает пользователю вопрос question
    public String askQuestion(Question qw){
        return null;
    }

    public void checkAnswer(String answer){

    }

    public String showStatistics(){
        Question question = new Question();
        return "Кол.во правильных: " + question.getGoodAnswer() +
                "Кол.во неправильных: " + question.getBadAnswer();
    }
}
