

package Boundry;

/**
 *
 * @author John Farrell 03650031
 */





import javax.swing.*;
import java.awt.Container;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.lang.Integer;
import java.util.StringTokenizer;



import control.*;
import employees.*;
import entity.Customer;




@SuppressWarnings("serial")
public class customerVerification implements ActionListener {

    static customerVerification myGUI;

    JFrame frame;
    JPanel panel;

    JLabel numberlabel;
    JTextField numberarea;

    JLabel namelabel;
    JTextArea namearea;

    JLabel staddresslabel;
    JTextArea staddressarea;

    JLabel cityaddresslabel;
    JTextArea cityaddressarea;
    
    JButton confirm;
    JButton change;
    JButton create;
    JButton check;
    JButton changeconfirm;
    ShopEmployee emp;
    Customer result;
    GridBagConstraints c;
    Queries q;

    @SuppressWarnings("serial")
    public customerVerification(ShopEmployee e)
    {

        emp=e;
        q = new Queries();


        frame = new JFrame("5 star pizza");
        panel = new JPanel();

        numberlabel = new JLabel("Number :") ;
        numberarea = new JTextField(20);

        namelabel = new JLabel("Name :") ;
        namearea=new JTextArea(1,20) ;
        namearea.setEditable(false);

        staddresslabel = new JLabel("Street :");
        staddressarea = new JTextArea(1,20);
        staddressarea.setEditable(false);

        cityaddresslabel= new JLabel("Address :");
        cityaddressarea =new JTextArea(1,20);
        cityaddressarea.setEditable(false);

        confirm= new JButton("Confirm Details") ;
        confirm.addActionListener(this);
        confirm.setVisible(false);
        change = new JButton("Change Details");
        change.addActionListener(this);
        change.setVisible(false);
        create= new JButton("Create Customer") ;
        create.addActionListener(this);
        create.setVisible(false);
        check = new JButton("Check Details");
        check.addActionListener(this);
        changeconfirm = new JButton("Set Changes");
        changeconfirm.addActionListener(this);
        changeconfirm.setVisible(false);

            

        panel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        
        c.gridx = 0;
	c.gridy = 0;
        panel.add(check,c);
        
        
        c.gridx = 0;
        c.gridy = 1;
	panel.add(numberlabel,c);
        
        
        c.gridx = 1;
        c.gridy = 1;
        panel.add(numberarea,c);
        
        
        c.gridx = 0;
        c.gridy = 2;
        panel.add(namelabel,c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(namearea,c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(staddresslabel,c);

        c.gridx = 1;
        c.gridy = 3;
        panel.add(staddressarea,c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(cityaddresslabel,c);

        c.gridx = 1;
        c.gridy = 4;
        panel.add(cityaddressarea,c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(confirm,c);

        c.gridx = 1;
        c.gridy = 5;
        panel.add(create,c);

        c.gridx = 2;
        c.gridy = 5;
        panel.add(change,c);

        c.gridx=0;
        c.gridy=6;
        panel.add(changeconfirm,c);

        
        frame.add(panel);



        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae)
    {

        if (ae.getSource()== check)
        {
            
          
            Queries q = new Queries();
            result = q.searchForCustomer(numberarea.getText());

            

            if( result != null)
            {
                StringTokenizer tk = new StringTokenizer(result.getAddress(),"," );
                namearea.setText(result.getName());
                staddressarea.setText(tk.nextToken());
                cityaddressarea.setText(tk.nextToken());
                confirm.setVisible(true);
                change.setVisible(true);

            }

            else if (result == null)
            {
                namearea.setText("Customer does not exist");
                staddressarea.setText("");
                cityaddressarea.setText("");
                create.setVisible(true);
            }
        }

        else if(ae.getSource()== confirm)
        {
            mainFrame main = new mainFrame(emp,result);
            frame.dispose();
        }
        else if (ae.getSource()==create)
        {
            newCustomer nc = new newCustomer(numberarea.getText());
            
        }

        else if (ae.getSource()== change)
        {
            numberarea.setEditable(false);
            staddressarea.setEditable(true);
            cityaddressarea.setEditable(true);
            changeconfirm.setVisible(true);

            panel.revalidate();
            panel.repaint();

        }
        
        else if (ae.getSource()==changeconfirm)
        {
            numberarea.setEditable(true);
            staddressarea.setEditable(false);
            cityaddressarea.setEditable(false);
            changeconfirm.setVisible(false);

            panel.revalidate();
            panel.repaint();
            
            q.editCustomerAddress(numberarea.getText(), staddressarea.getText(),cityaddressarea.getText());

        }


        
    }



}
