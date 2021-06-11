package fr.gamedev.question.swing.question.swing;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author djer13
 */
@Component
public class MainFrame extends JFrame {
    /** serialVersionUID */
    private static final long serialVersionUID = 2827577217081048727L;

    private JButton exit;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem quitMenu;
    private QuitAction quitAction;

    private JPanel mainPan;
    private QuestionPanel questionPan;

    private AnswerPanel answerPan;

    public MainFrame(@Autowired QuestionPanel theQuestionpan, @Autowired AnswerPanel theAnswerPanel) {
        questionPan = theQuestionpan;
        answerPan = theAnswerPanel;

        quitAction = new QuitAction("Fermer", this);

        //menuBar
        menuBar = new JMenuBar();
        menuFile = new JMenu("Fichier");
        quitMenu = new JMenuItem(quitAction);

        menuFile.add(quitMenu);
        menuBar.add(menuFile);

        super.setJMenuBar(menuBar);

        // -- Exit button
        exit = new JButton(quitAction);//create button

        mainPan = new JPanel();
        mainPan.setLayout(new BoxLayout(mainPan, BoxLayout.PAGE_AXIS));

        mainPan.add(questionPan);
        mainPan.add(answerPan);

        this.getContentPane().add(exit, BorderLayout.PAGE_END);
        this.getContentPane().add(mainPan, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 200);
    }

}
