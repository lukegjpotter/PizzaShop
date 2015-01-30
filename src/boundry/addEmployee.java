package Boundry;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import control.*;

/**
 * @author John Martin Farrell
 *
 */

@SuppressWarnings("serial")
public class addEmployee extends JFrame implements ActionListener {
	
	
	JRadioButton delivery;
	JRadioButton shop;
	ButtonGroup empgroup;
	JTextField fname;
	JTextField sname;
	JTextField hourlyrate;
	JPasswordField pass1;
	JPasswordField pass2;
	JTextField carreg;
	JTextField feulcard;
	static addEmployee myGUI;
	JButton create;
	JButton cancel;
        Queries q;
	
	
	public addEmployee()
	{
                q = new Queries();
		
		//layout manager added to container
		FlowLayout fl = new FlowLayout();
		Container cont = getContentPane();
		cont.setLayout(fl);
		
		JLabel emptype = new JLabel("Employee Type:");
		
		delivery = new JRadioButton("Delivery");
		delivery.setActionCommand("delivery");
		delivery.addActionListener(this);
		shop = new JRadioButton("Shop");
		shop.setActionCommand("shop");
		shop.addActionListener(this);
		
		//create a radio group and add radio buttons 
		empgroup = new ButtonGroup();
		empgroup.add(delivery);
		empgroup.add(shop);
		
		JLabel uidLabel = new JLabel("Firstname : ");
		fname = new JTextField(5);
		JLabel nameLabel = new JLabel("Surame : ");
		sname = new JTextField(10);
		JLabel hrrLabel = new JLabel("Hourly Rate : ");
		hourlyrate = new JTextField(5);
		
		JLabel emptype1 = new JLabel("Shop Emloyee");		
		
		JLabel pass1Label = new JLabel("Password : ");
		pass1 = new JPasswordField(10);
		JLabel pass2Label = new JLabel("Retype password : ");
		pass2 = new JPasswordField(10);
		
		JLabel emptype2 = new JLabel("Delivery Emloyee");	
		
		JLabel carregLabel = new JLabel("Car Registration No. : ");
		carreg = new JTextField(10);
		JLabel feulcardLabel = new JLabel("Fuel Card No. : ");
		feulcard = new JTextField(10);
		
		create = new JButton("Create");
		create.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);

                GridBagConstraints c = new GridBagConstraints();
		cont.setLayout(new GridBagLayout());


		c.gridx = 0;
		c.gridy = 0;
		cont.add(emptype,c);

                c.gridx = 1;
		c.gridy = 0;
		cont.add(delivery,c);

                c.gridx = 2;
		c.gridy = 0;
		cont.add(shop,c);

                c.gridx = 0;
		c.gridy = 1;
		cont.add(uidLabel,c);

                c.gridx = 1;
		c.gridy = 1;
		cont.add(fname,c);

                c.gridx = 0;
		c.gridy = 2;
		cont.add(nameLabel,c);

                c.gridx = 1;
		c.gridy = 2;
		cont.add(sname,c);

                c.gridx = 0;
		c.gridy = 3;
		cont.add(hrrLabel,c);

                c.gridx = 1;
		c.gridy = 3;
		cont.add(hourlyrate,c);

                c.gridx = 0;
		c.gridy = 4;
		cont.add(emptype1,c);

                c.gridx = 0;
		c.gridy = 5;
		cont.add(pass1Label,c);

                c.gridx = 1;
		c.gridy = 5;
		cont.add(pass1,c);

                c.gridx = 0;
		c.gridy = 6;
		cont.add(pass2Label,c);

                c.gridx = 1;
		c.gridy = 6;
		cont.add(pass2,c);

                c.gridx = 0;
		c.gridy = 7;
		cont.add(emptype2,c);

                c.gridx = 0;
		c.gridy = 8;
		cont.add(carregLabel,c);

                c.gridx = 1;
		c.gridy = 8;
		cont.add(carreg,c);

                c.gridx = 0;
		c.gridy = 9;
		cont.add(feulcardLabel,c);

                c.gridx = 1;
		c.gridy = 9;
		cont.add(feulcard,c);

                c.gridx = 0;
		c.gridy = 10;
		cont.add(create,c);

                c.gridx = 1;
		c.gridy = 10;
		cont.add(cancel,c);

                this.setLocationRelativeTo(null);
		setVisible(true);
		setSize(500, 400);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(delivery.isSelected())
		{
			pass1.setEnabled(false);
			pass2.setEnabled(false);
			carreg.setEnabled(true);	
			feulcard.setEnabled(true);
                        
			
		}
		else if (shop.isSelected())
		{
			carreg.setEnabled(false);	
			feulcard.setEnabled(false);
			pass1.setEnabled(true);
			pass2.setEnabled(true);
                        
		}
		else
		{
			
		}

                if(e.getSource()== cancel)
                {
                    dispose();
                }

                else if(e.getSource()== create && delivery.isSelected())
                {
                    String fn = fname.getText();
                    String sn = sname.getText();
                    String ratest = hourlyrate.getText();
                    double rate = Double.parseDouble(ratest);
                    String car = carreg.getText();
                    String feul = feulcard.getText();
                    int fuel = Integer.parseInt(feul);
                    
                    q.createNewDeliveryEmployee(fn,sn,rate,car,fuel);
                    
                    dispose();
                }
                
                else if(e.getSource()== create && shop.isSelected())
                {
                    
                    String fn = fname.getText();
                    String sn = sname.getText();
                    String ratest = hourlyrate.getText();
                    double rate = Double.parseDouble(ratest);
                    char[] passw1=pass1.getPassword();
                    char[] passw2=pass2.getPassword();
                    


                    if(Arrays.equals(passw1,passw2 ) == true)
                    {
                        q.createNewShopEmployee(fn, sn, rate, new String(pass1.getPassword()));
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "Passwords are not the same");
                        
                    }
                    
                    dispose();
                    
                }
		
		
		
		
		
	}

	
//	//main creates the gui and applies properties
//	public static void main(String[] args) {
//		myGUI= new addEmployee();
//		myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		myGUI.setResizable(false);
//	}
}
