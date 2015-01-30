package Boundry;
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

import entity.Customer;
import control.Queries;

/**
 * @author John Martin Farrell
 *
 */




@SuppressWarnings("serial")
public class newCustomer extends JFrame implements ActionListener {
	

        
	JTextArea number;
	JTextField name;
	JTextField streetaddress;
	JTextField surname;
	JTextField cityaddress;
	JButton buttonadd;
	JButton buttoncancel;
	static newCustomer myGUI;
	Queries q;
	
	
	
	public newCustomer(String num) {

            q= new Queries();

		//layout manager added to container
		FlowLayout fl = new FlowLayout();
		Container cont = getContentPane();
		cont.setLayout(fl);
		

		number = new JTextArea(1,10);
                number.append(num);
		name = new JTextField(20);
		surname = new JTextField(20);
		streetaddress = new JTextField(20);
		cityaddress = new JTextField(20);
		
		JLabel numberLabel = new JLabel("Number : ");
		JLabel nameLabel = new JLabel("Name : ");
		JLabel surnameLabel = new JLabel("Surname : ");
		JLabel streetaddressLabel = new JLabel("Street : ");
		JLabel cityaddressLabel = new JLabel("City : ");
		
		buttonadd = new JButton("Create Account");
		buttonadd.addActionListener(this);
		
		buttoncancel = new JButton("Cancel");
		buttoncancel.addActionListener(this);

                GridBagConstraints c = new GridBagConstraints();
		cont.setLayout(new GridBagLayout());

		
		c.gridx = 0;
		c.gridy = 0;
		cont.add(numberLabel,c);

                c.gridx = 1;
		c.gridy = 0;
		cont.add(number,c);

                c.gridx = 0;
		c.gridy = 1;
		cont.add(nameLabel,c);

                c.gridx = 1;
		c.gridy = 1;
		cont.add(name,c);

                c.gridx = 0;
		c.gridy = 2;
		cont.add(surnameLabel,c);

                c.gridx = 1;
		c.gridy = 2;
		cont.add(surname,c);

                c.gridx = 0;
		c.gridy = 3;
		cont.add(streetaddressLabel,c);

                c.gridx = 1;
		c.gridy = 3;
		cont.add(streetaddress,c);

                c.gridx = 0;
		c.gridy = 4;
		cont.add(cityaddressLabel,c);

                c.gridx = 1;
		c.gridy = 4;
		cont.add(cityaddress,c);

                c.gridx = 0;
		c.gridy = 5;
		cont.add(buttonadd,c);

                c.gridx = 1;
		c.gridy = 5;
		cont.add(buttoncancel,c);
		
		setVisible(true);
		setSize(400, 200);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String uidnum,num, surnamein,namein, streetaddressin,cityaddressin;
		
		if (e.getSource()== buttonadd)
		{
			num = number.getText();
			uidnum= number.getText();
			namein = name.getText();
			surnamein = surname.getText();
			streetaddressin= streetaddress.getText();
			cityaddressin= cityaddress.getText();
			
			q.createNewCustomer(uidnum, namein,surnamein,streetaddressin,cityaddressin);
			
                        
//			System.out.print(c.toString());
			dispose();
		}
		else if (e.getSource() == buttoncancel)
		{
			dispose();
		}
		
	}
	
//	//main creates the gui and applies properties
//	public static void main(String[] args) {
//		myGUI = new newCustomer();
//		myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		myGUI.setResizable(false);
//	}


//        public void run()
//        {
//            myGUI = new newCustomer();
//            myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
//            myGUI.setResizable(false);
//        }

}
