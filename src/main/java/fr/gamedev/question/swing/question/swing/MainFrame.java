package fr.gamedev.question.swing.question.swing;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author djer1
 *
 */
public class MainFrame extends JFrame {
    /** serialVersionUID */
    private static final long serialVersionUID = 2827577217081048727L;

    private JButton exit;

    public MainFrame() {
        exit = new JButton("quit ?");//create button  
        exit.setBounds(130, 100, 100, 40);

        add(exit);//adding button on frame  
        setSize(400, 500);
        setLayout(null);
    }

}
