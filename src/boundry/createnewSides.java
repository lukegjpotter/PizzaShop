

package Boundry;

/**
 *
 * @author John Farrell 03650031
 */



import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Queries;
import java.awt.Color;

public class createnewSides implements ActionListener{

    JFrame frame ;
    JPanel sidespanel;
    JButton addside;
    
    ButtonGroup type;

    JRadioButton side ;
    JRadioButton drink ;
    JRadioButton desert;
    JRadioButton basestyle;
    JRadioButton sauce ;
    JRadioButton toping ;


    JTextArea  namearea;
    JTextArea  descarea;
    JTextArea  sizearea;
    JTextArea  pricearea;

    Queries q;


    public createnewSides()
    {

        frame = new JFrame();

        q = new Queries();

        
        sidespanel = new JPanel();
        GridBagConstraints pp = new GridBagConstraints();
        sidespanel.setLayout(new GridBagLayout());
        
        type = new ButtonGroup();

        JLabel typelabel = new JLabel("Type : ");

        side = new JRadioButton("Side Order");
        side.setActionCommand("Side Order");
        side.addActionListener(this);
        type.add(side);
        drink = new JRadioButton("Drink");
        drink.setActionCommand("Drink");
        drink.addActionListener(this);
        type.add(drink);
        desert = new JRadioButton("Desert");
        desert.setActionCommand("Desert");
        desert.addActionListener(this);
        type.add(desert);

        basestyle = new JRadioButton("Base");
        basestyle.setActionCommand("Base");
        basestyle.addActionListener(this);
        type.add(basestyle);
        sauce = new JRadioButton("Sauce");
        sauce.setActionCommand("Sauce");
        sauce.addActionListener(this);
        type.add(sauce);
        toping = new JRadioButton("Topping");
        toping.setActionCommand("Topping");
        toping.addActionListener(this);
        type.add(toping);

        JPanel buttonpanel = new JPanel();

        buttonpanel.add(typelabel);
        buttonpanel.add(side);
        buttonpanel.add(drink);
        buttonpanel.add(desert);
        buttonpanel.add(basestyle);
        buttonpanel.add(side);
        buttonpanel.add(sauce);
        buttonpanel.add(toping);

        JLabel namelabel = new JLabel("Name");
        namearea= new JTextArea(1,10);
        namearea.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel desclabel = new JLabel("Description");
        descarea= new JTextArea(1,10);
        descarea.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel sizelabel = new JLabel("Size");
        sizearea= new JTextArea(1,10);
        sizearea.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel pricelabel = new JLabel("Price");
        pricearea= new JTextArea(1,10);
        pricearea.setBorder(BorderFactory.createLineBorder(Color.black));

        addside = new JButton("Add Side");
        addside.addActionListener(this);
        

        pp.gridx=0;
        pp.gridy=0;
        sidespanel.add(buttonpanel,pp);

        pp.gridx=0;
        pp.gridy=1;
        sidespanel.add(namelabel,pp);

        pp.gridx=1;
        pp.gridy=1;
        sidespanel.add(namearea,pp);
        
        pp.gridx=0;
        pp.gridy=2;
        sidespanel.add(desclabel,pp);
        
        pp.gridx=1;
        pp.gridy=2;
        sidespanel.add(descarea,pp);
        
        pp.gridx=0;
        pp.gridy=3;
        sidespanel.add(sizelabel,pp);
        
        pp.gridx=1;
        pp.gridy=3;
        sidespanel.add(sizearea,pp);
        
        pp.gridx=0;
        pp.gridy=4;
        sidespanel.add(pricelabel,pp);
        
        pp.gridx=1;
        pp.gridy=4;
        sidespanel.add(pricearea,pp);

        pp.gridx=0;
        pp.gridy=5;
        sidespanel.add(addside,pp);

        frame.add(sidespanel);



        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

    }

    @Override
	public void actionPerformed(ActionEvent ae)
    {
        if (side.isSelected())
        {
            sizearea.setEditable(false);
        }

        else if (basestyle.isSelected())
        {
            sizearea.setEditable(false);
            pricearea.setEditable(false);
        }

        else if (sauce.isSelected())
        {
            sizearea.setEditable(false);
            pricearea.setEditable(false);
            descarea.setEditable(false);;
        }

        else if (toping.isSelected())
        {
            sizearea.setEditable(false);
            pricearea.setEditable(false);
            descarea.setEditable(false);;
        }

        if (ae.getSource()== addside)
        {
            String name = namearea.getText();
            String desc = descarea.getText();
            String s = sizearea.getText();
            double size = Double.parseDouble(s);
            String price = pricearea.getText();
            double p = Double.parseDouble(price);

            if(side.isSelected())
            {
                q.persistSideOrder(name, desc, p);
            }

            else if (drink.isSelected())
            {
                q.persistDrink(name, desc, size, p);
            }

            else if (desert.isSelected())
            {
                q.persistDesert(name, desc, size, p);
            }

            else if (basestyle.isSelected())
            {
                q.persistBaseStyle(name, desc);
            }

            else if (sauce.isSelected())
            {
                q.persistSauce(name);
            }

            else if (toping.isSelected())
            {
                q.persistToping(name);
            }

        }
    }

}
