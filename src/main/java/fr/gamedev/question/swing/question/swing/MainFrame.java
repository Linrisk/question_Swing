package fr.gamedev.question.swing.question.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author djer13
 */
public class MainFrame extends JFrame implements ActionListener {
    /** serialVersionUID */
    private static final long serialVersionUID = 2827577217081048727L;

    private JButton exit;

    public MainFrame() {
        exit = new JButton("quitter ?");//create button  
        exit.setBounds(130, 100, 100, 40);
        exit.setActionCommand("quit");
        exit.addActionListener(this);

        super.add(exit);//adding button on frame  
        super.setSize(400, 500);
        super.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("quit".equals(e.getActionCommand())) {
            super.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

}
