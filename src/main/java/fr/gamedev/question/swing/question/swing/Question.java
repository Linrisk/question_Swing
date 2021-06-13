package fr.gamedev.question.swing.question.swing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author djer13
 *
 */
public class Question {

    private long questionId;
    private String question;
    private Map<String, String> possibleAnswers = new HashMap<>();
    private String userAnswer;

    /**
     * @return the questionId
     */
    public long getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId the questionId to set
     */
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the possibleAnswers
     */
    public Map<String, String> getPossibleAnswers() {
        return possibleAnswers;
    }

    /**
     * @param possibleAnswers the possibleAnswers to set
     */
    public void setPossibleAnswers(Map<String, String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    /**
     * @return the userAnswer
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * @param userAnswer the userAnswer to set
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

}
