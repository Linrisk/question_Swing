package fr.gamedev.question.swing.question.swing;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author djer13
 *
 */
@Component
public class QuestionPanel extends JPanel {

    /** serialVersionUID */
    private static final long serialVersionUID = -2635541286040432196L;

    QuestionService questionService;

    private JTextField question;

    public QuestionPanel(@Autowired QuestionService theQuestionService) {
        questionService = theQuestionService;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        question = new JTextField();
        question.setText(getQuestion("test0"));
        question.setEnabled(false);

        this.add(question);

    }

    private String getQuestion(String userId) {
        Question theQuestion = questionService.getQuestion("test0");

        String questionText = theQuestion.getQuestion();

        if (null == questionText) {
            questionText = "oops pas de question disponible";
        }

        return questionText;
    }

}
