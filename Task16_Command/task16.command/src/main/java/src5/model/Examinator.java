package src5.model;

import java.util.*;

// генерирует N вопросов из базы, получает ответ на каждый вопрос и проверяет его правильность, после N ответов выводит статистику.

public class Examinator {
    private Storage storage;
    private List<Question> questions;
    private int questionCount;
    private int answeredCount;
    private int correctCount;
    private Random random;

    public Examinator() {
        storage = new Storage();
        questions = new ArrayList<>();
        questionCount = 3;
        answeredCount = 0;
        correctCount = 0;
        random = new Random();
        generateQuestions();
    }

    // Генерирует N вопросов из базы данных
    private void generateQuestions() {
        List<Question> allQuestions = storage.getQuestionsList();
        int availableQuestionCount = allQuestions.size();

        // Если доступное количество вопросов меньше, чем требуемое количество,
        // используем все доступные вопросы
        if (availableQuestionCount <= questionCount) {
            questions.addAll(allQuestions);
        } else {
            // Генерируем случайные индексы вопросов
            Set<Integer> randomIndexes = new HashSet<>();
            while (randomIndexes.size() < questionCount) {
                int randomIndex = random.nextInt(availableQuestionCount);
                randomIndexes.add(randomIndex);
            }

            // Извлекаем выбранные вопросы
            for (int index : randomIndexes) {
                questions.add(allQuestions.get(index));
            }
        }
    }

    // Возвращает следующий вопрос для ответа
    public Question action() {
        if (answeredCount < questionCount) {
            return questions.get(answeredCount);
        }
        return null;
    }

    // Проверяет ответ на вопрос
    public boolean check(String answer) {
        if (answeredCount < questionCount) {
            Question currentQuestion = questions.get(answeredCount);
            boolean isCorrect = currentQuestion.getGoodAnswer().contains(answer);
            if (isCorrect) {
                correctCount++;
            }
            answeredCount++;
            return isCorrect;
        }
        return false;
    }

    // Возвращает статистику по результатам теста
    public String end() {
        return "Statistics:\n" +
                "Question Count: " + questionCount + "\n" +
                "Answered Count: " + answeredCount + "\n" +
                "Correct Count: " + correctCount + "\n";
    }

    // Проверяет, завершен ли экзамен
    public boolean isExamFinished() {
        return answeredCount >= questionCount;
    }
}