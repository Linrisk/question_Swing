package fr.gamedev.question.swing.question.swing;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author djer13
 */
public class MainFrame extends JFrame {
    /** serialVersionUID */
    private static final long serialVersionUID = 2827577217081048727L;

    private JButton exit;
    //bidule 

    public MainFrame() {
        exit = new JButton("quitter ?");//create button  
        exit.setBounds(130, 100, 100, 40);

        super.add(exit);//adding button on frame  
        super.setSize(400, 500);
        super.setLayout(null);
    }
}
