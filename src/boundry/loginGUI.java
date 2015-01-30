package Boundry;
import java.awt.Container;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import control.Queries;
import employees.*;

/**
 * @author John Martin Farrell
 *
 */


@SuppressWarnings("serial")
public class loginGUI extends JFrame implements ActionListener{


    JFrame frame;
    JTextField uid;
    JPasswordField pass;
    JButton button;
    static loginGUI myGUI;
    Queries q = new Queries();

	public loginGUI() 
	{
		

            frame = new JFrame("5 Star Pizza");

            Container cont = getContentPane();



            uid = new JTextField(10);
            pass = new JPasswordField(15);
            button = new JButton("Log in");
            button.addActionListener(this);


            JLabel uidLabel = new JLabel("User ID : ");
            JLabel passLabel = new JLabel("Password : ");


            GridBagConstraints c = new GridBagConstraints();
            cont.setLayout(new GridBagLayout());

            c.gridx = 0;
            c.gridy = 0;
            cont.add(uidLabel,c);

            c.gridx = 1;
            c.gridy = 0;
            cont.add(uid,c);

            c.gridx = 0;
            c.gridy = 1;
            cont.add(passLabel,c);

            c.gridx = 1;
            c.gridy = 1;
            cont.add(pass,c);

            c.gridx = 1;
            c.gridy = 2;
            cont.add(button,c);

            frame.add(cont);

            frame.pack();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(400, 200);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);


	}
	
	public void actionPerformed(ActionEvent e) {
		
		String strins1 = "martin";
		String string2 = "001";
		
		String uidin,passcheck;
		char[] passin;
		uidin = uid.getText();
		passin = pass.getPassword();
		passcheck = convertPassword(passin);

                ShopEmployee emp = q.employeeLogin(uidin,  passcheck);

                if (emp == null)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Login Details");
                }

                else
                {
                    customerVerification cv = new customerVerification(emp);
                    frame.dispose();
                }
		
//		if(uidin.equals(strins1) && passcheck.equals(string2)  )
//		{
//			System.out.print("Logged in ");
//                        customerVerification cv = new customerVerification(null);
//                        frame.dispose();
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(null, "Incorrect Login Details");
//		}
//
	}
	
	
	//main creates the gui and applies properties
//	public static void main(String[] args) {
//		myGUI = new loginGUI();
//		myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		myGUI.setResizable(false);
//	}
	
	public static String convertPassword(char[] cPassword)
    {
            // Declare variables
            String strRet = new String(cPassword);
           
            // Go through each character
           
            return strRet;
    }

}
