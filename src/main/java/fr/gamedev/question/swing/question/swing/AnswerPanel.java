package fr.gamedev.question.swing.question.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.springframework.stereotype.Component;

/**
 * @author djer13
 *
 */
@Component
public class AnswerPanel extends JPanel implements ActionListener {

    /** serialVersionUID */
    private static final long serialVersionUID = -5286529128340881438L;

    private ButtonGroup chooseAnswerRadios;
    private JRadioButton trueButton;
    private JRadioButton falseButton;
    private JButton sendButton;

    public AnswerPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        chooseAnswerRadios = new ButtonGroup();
        trueButton = new JRadioButton("true");
        falseButton = new JRadioButton("false");
        chooseAnswerRadios.add(trueButton);
        chooseAnswerRadios.add(falseButton);

        sendButton = new JButton("Envoyer !");
        sendButton.addActionListener(this);

        this.add(trueButton);
        this.add(falseButton);
        this.add(sendButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Pas encore implémenté ! ");
    }
}
