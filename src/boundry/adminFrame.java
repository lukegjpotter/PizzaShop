

package Boundry;

import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
/**
 *
 * @author John Farrell 03650031
 */
public class adminFrame implements ActionListener{

    JFrame frame;
    JMenuBar menu;
    JMenu file;
    JMenuItem addcuspizza;
    JMenuItem addemp;
    JMenuItem addside;
    JMenuItem exit;

    public adminFrame()
    {
        frame = new JFrame("5 Star Pizza");
        
        
        
        
        menu = new JMenuBar() ;
//        menu.setLocation(0, 0);
        file = new JMenu("File");
        addcuspizza = new JMenuItem("Add Custom Pizza");
        addcuspizza.addActionListener(this);
        addemp = new JMenuItem("Add Employee");
        addemp.addActionListener(this);
        addside = new JMenuItem("Add Side");
        addside.addActionListener(this);
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        file.add(addcuspizza);
        file.add(addemp);
        file.add(addside);
        file.add(exit);
        menu.add(file);
        frame.setJMenuBar(menu);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {


            if(ae.getSource()==addcuspizza)
            {
                addCustomPizza addc = new addCustomPizza();
            }
            else if (ae.getSource()==addemp)
            {
                addEmployee adde = new addEmployee();
            }
            else if (ae.getSource()==addside)
            {
                createnewSides adds = new createnewSides();
            }

            else if (ae.getSource()==exit)
            {
                frame.dispose();
            }

    }

}
