package fr.gamedev.question.swing.question.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author djer13
 *
 */
@Component
public class QuestionPanel extends JPanel implements ActionListener {

    /** serialVersionUID */
    private static final long serialVersionUID = -2635541286040432196L;
    private static final String DEFAULT_QUESTION_MESSAGE = "Initialisation";

    /** Service to communicate with backEndServer. */
    private QuestionService questionService;

    private JPanel displayQuestionPan;
    private JLabel questionLabel;
    private JButton refreshButton;
    private JTextField question;

    /** The current answer (and meta-data) displayed to user. */
    private Question theQuestion = null;

    private String userId;

    public QuestionPanel(@Autowired QuestionService theQuestionService) {
        questionService = theQuestionService;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        displayQuestionPan = new JPanel();
        displayQuestionPan.setLayout(new BoxLayout(displayQuestionPan, BoxLayout.LINE_AXIS));

        questionLabel = new JLabel();
        questionLabel.setText("Répondez à cette question : ");

        refreshButton = new JButton();
        refreshButton.setText("refreh");
        refreshButton.addActionListener(this);

        question = new JTextField();
        question.setText(DEFAULT_QUESTION_MESSAGE);
        question.setEnabled(false);

        displayQuestionPan.add(question);
        displayQuestionPan.add(refreshButton);

        this.add(questionLabel);
        this.add(displayQuestionPan);
    }

    public void displayQuestion() {
        question.setText(DEFAULT_QUESTION_MESSAGE);
        theQuestion = questionService.getQuestion(userId);

        String questionText = theQuestion.getQuestion();

        if (null == questionText) {
            questionText = "oops pas de question disponible";
        }

        question.setText(questionText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.displayQuestion();
    }

    /**
     * @return the theQuestion
     */
    public Question getTheQuestion() {
        return theQuestion;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
