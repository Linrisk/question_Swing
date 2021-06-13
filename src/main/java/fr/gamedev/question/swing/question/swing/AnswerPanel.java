package fr.gamedev.question.swing.question.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.springframework.stereotype.Component;

/**
 * Provide UI to allow user to answer a question.
 * @author djer13
 */
@Component
public class AnswerPanel extends JPanel implements ActionListener {

    /** serialVersionUID */
    private static final long serialVersionUID = -5286529128340881438L;

    private JPanel possibleAnswersPan;
    private ButtonGroup chooseAnswerGroup;
    private List<JRadioButton> allButtonChoices;
    private JButton sendButton;

    /** The question to answer. Also contains the use provided answer. */
    private Question theQuestion;

    public AnswerPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        possibleAnswersPan = new JPanel();
        possibleAnswersPan.setLayout(new BoxLayout(possibleAnswersPan, BoxLayout.PAGE_AXIS));

        chooseAnswerGroup = new ButtonGroup();
        allButtonChoices = new ArrayList<JRadioButton>();
        //Choices are added when the question is provided.

        sendButton = new JButton("Envoyer !");
        sendButton.addActionListener(this);

        this.add(possibleAnswersPan);
        this.add(sendButton);
    }

    /** Clear and remove previous Radio Button for possible answer and create a new one. */
    private void refreshPossibleAnswerRadioButtons() {
        if (null != theQuestion) {
            this.invalidate();
            //clean existing data for possibles answers.
            possibleAnswersPan.removeAll();
            for (JRadioButton previousButton : allButtonChoices) {
                chooseAnswerGroup.remove(previousButton);
            }
            allButtonChoices.clear();

            // Add new choice, from the Question data Model.
            for (String possibility : theQuestion.getPossibleAnswers().keySet()) {
                String defaultDisplayMessage = theQuestion.getPossibleAnswers().get(possibility);
                JRadioButton rButton = new JRadioButton(defaultDisplayMessage);
                rButton.setActionCommand(possibility);
                allButtonChoices.add(rButton);

                chooseAnswerGroup.add(rButton);
                possibleAnswersPan.add(rButton);
            }
        }
    }

    /** Retrieve value of selected radio button. */
    public String getSelectedValue() {
        String selectedValue = null;
        if (null != chooseAnswerGroup.getSelection()) {
            selectedValue = chooseAnswerGroup.getSelection().getActionCommand();
        }
        return selectedValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        theQuestion.setUserAnswer(getSelectedValue());
        JOptionPane.showMessageDialog(this,
                "Pas encore implémenté ! (Sera envoyé : " + theQuestion.getUserAnswer() + ")");
    }

    /**
     * @param theQuestion the theQuestion to set
     */
    public void setTheQuestion(Question theQuestion) {
        this.theQuestion = theQuestion;
        refreshPossibleAnswerRadioButtons();
    }

}
