package src5.model;

import java.util.List;
import java.util.Random;

public class Leaner {
    private Storage storage;
    private Question currentQuestion;
    private boolean isQuestionAnswered;
    Random random;

    public Leaner() {
        storage = new Storage();
        currentQuestion = null;
        isQuestionAnswered = true;
        random = new Random();
    }

    public Question action() {
        if (isQuestionAnswered) {
            List<Question> questionsList = storage.getQuestionsList();
            if (!questionsList.isEmpty()) {
                currentQuestion = questionsList.get(random.nextInt(questionsList.size()));
                isQuestionAnswered = false;
                return currentQuestion;
            }
        }
        return null;
    }

    public boolean check(String answer) {
        if (currentQuestion != null) {
            boolean isCorrect = currentQuestion.getGoodAnswer().contains(answer);
            if (isCorrect) {
                isQuestionAnswered = true;
            }
            return isCorrect;
        }
        return false;
    }

    public String end() {
        return "Ответ был дан верно. Введите команду!";
    }
}
