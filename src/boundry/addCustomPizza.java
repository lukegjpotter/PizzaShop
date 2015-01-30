
package Boundry;

import javax.swing.*;


import java.awt.Checkbox;

import java.awt.Container;

import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
;
import java.util.List;
import java.util.ArrayList;


import products.*;
import control.*;






public class addCustomPizza extends JFrame implements ActionListener {

	static addCustomPizza myGUI;
	JFrame frame;


        JPanel Basepanel;
        JPanel Saucepanel;
        JPanel Toppanel;

        JButton addpizzabutton;

        ButtonGroup basegroup;
        ButtonGroup saucegroup;
        List <Checkbox> cblist;
	
	JTextArea name;


	

	
	JPanel pizzapanel1;


        List <BaseStyle> base;
        List <Sauce> sauce;
        List<Toping> topings;
        
        Queries q;



	public addCustomPizza()
	{

            q = new Queries() ;

		frame = new JFrame("5 star pizza");

		//layout manager added to container
		FlowLayout fl = new FlowLayout();
		Container cont = getContentPane();
		cont.setLayout(fl);
		

                JPanel pizzaname = new JPanel();
                JLabel pizzanamelabel =  new JLabel("Pizza Name : ");
                JTextArea pizzanamein = new JTextArea(1,20);
                pizzaname.add(pizzanamelabel);
                pizzaname.add(pizzanamein);
		
		
		pizzapanel1 = new JPanel();

                JPanel namelabel = new JPanel();
                namelabel.add(new JLabel("Pizza Name :"));

                name = new JTextArea(1,20);


                addpizzabutton = new JButton("Add Item");
                addpizzabutton.addActionListener(this);

                JPanel baselabel = new JPanel();
                baselabel.add(new JLabel("Bases :"));

                Basepanel = getBases();



                JPanel saucelabel = new JPanel();
                saucelabel.add(new JLabel("Sauces :"));

                Saucepanel = getSauces();

                JPanel toplabel = new JPanel();
                toplabel.add(new JLabel("Toppings :"));

                Toppanel = getToppings();


                GridBagConstraints pp = new GridBagConstraints();
                pizzapanel1.setLayout(new GridBagLayout());

                
                pp.gridx = 0;
                pp.gridy = 0;
                pizzapanel1.add(namelabel,pp);

                pp.gridx = 1;
                pp.gridy = 0;
                pizzapanel1.add(name,pp);
                
                pp.gridx = 0;
                pp.gridy = 1;
                pizzapanel1.add(baselabel,pp);

                pp.gridx = 1;
                pp.gridy = 1;
                pizzapanel1.add(Basepanel,pp);

                pp.gridx = 0;
                pp.gridy = 2;
                pizzapanel1.add(saucelabel,pp);

                pp.gridx = 1;
                pp.gridy = 2;
                pizzapanel1.add(Saucepanel,pp);

                pp.gridx = 0;
                pp.gridy = 3;
                pizzapanel1.add(toplabel,pp);

                pp.gridx = 1;
                pp.gridy = 3;
                pizzapanel1.add(Toppanel,pp);


                
                pp.gridx = 0;
                pp.gridy = 4;
                pizzapanel1.add(addpizzabutton,pp);

		
		


		//System Status
		
		cont.add(pizzapanel1);
		cont.setVisible(true);

		
		frame.add(cont);



		frame.pack();
		frame.setVisible(true);
		frame.setSize(600, 420);
		frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);





	}




	@Override
	public void actionPerformed(ActionEvent ae) {
		
                
                if(ae.getSource()==addpizzabutton)
                {
                    String namee = name.getText();
                    String basee = basegroup.getSelection().getActionCommand();

                    String saucee = saucegroup.getSelection().getActionCommand();

                    List <Toping> topss = new ArrayList();
                    for(Checkbox c :cblist)
                    {

                        if (c.getState()==true)
                        {
                            int index = cblist.indexOf(c);
                            topss.add(topings.get(index));
                        }

                    }


                    Pizza p = new Pizza(namee,base.get(Integer.parseInt(basee)),sauce.get(Integer.parseInt(saucee)),topss);

                    q.persistPizza (namee,base.get(Integer.parseInt(basee)),sauce.get(Integer.parseInt(saucee)),topss);

                }

	}

//	//main creates the gui and applies properties
//	public static void main(String[] args) {
//		myGUI= new addCustomPizza();
//		myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		myGUI.setResizable(false);
//
//
//
//
//	}

	public String getInfo()
	{
		return  "Logged in as : Martin Farrell "+"\n"+"Customer      : Mr. Potter";
	}

        public JPanel getToppings()
        {
            topings = q.returnAllTopings ();
                JPanel toppanel = new JPanel();
                toppanel.setLayout(new GridLayout((int)Math.floor(topings.size()/3),3));

                cblist = new <Checkbox> ArrayList();
                for (Toping tops : topings)
                {
                    if(tops.getName().equals("Cheese"))
                    {
                        Checkbox cb = new Checkbox(tops.getName(),null,true);
                        cb.setName(tops.getName());
                        cblist.add(cb);
                        toppanel.add(cb);
                    }
                    else
                    {
                        Checkbox cb = new Checkbox(tops.getName(),null,false);
                        cb.setName(tops.getName());
                        cblist.add(cb);

                        toppanel.add(cb);
                    }

                }
                return toppanel;
        }

        
        public JPanel getSauces()
        {
            sauce =q.returnAllSauces();
            JPanel saucelabel = new JPanel();


            saucelabel.add(new JLabel("Sauces :"));

            JPanel saucepanel = new JPanel();
            saucepanel.setLayout(new GridLayout(3,(int)Math.floor(sauce.size()/3)));



            saucegroup = new ButtonGroup();

            int i = 0;
            for (Sauce sau: sauce)
            {
                if (sau.getName().equals("Tomato"))
                {
                    JRadioButton sauceb = new JRadioButton(sau.getName(),true);
                    sauceb.setActionCommand(Integer.toString(i));
                    saucegroup.add(sauceb);
                    saucepanel.add(sauceb);
                    i++;
                }
                else
                {
                    JRadioButton sauceb = new JRadioButton(sau.getName());
                    sauceb.setActionCommand(Integer.toString(i));
                    saucegroup.add(sauceb);
                    saucepanel.add(sauceb);
                    i++;
                }

            }

            return saucepanel;

        }

        public JPanel getBases()
        {
            base = q.returnAllBaseStyles ();


            JPanel basepanell = new JPanel();
            basegroup = new ButtonGroup();
            basepanell = new JPanel();
            basepanell.setLayout(new GridLayout(3,(int)Math.floor(base.size()/3)));


            for (BaseStyle b :base)
            {
                int i=0;
                if (b.getName().equals("Regular"))
                {
                    JRadioButton baserb = new JRadioButton(b.getName(),true);
                    baserb.setActionCommand(Integer.toString(i));
                    basegroup.add(baserb);
                    basepanell.add(baserb);
                    i++;
                }
                else
                {
                    JRadioButton baserb = new JRadioButton(b.getName());
                    baserb.setActionCommand(Integer.toString(i));
                    basegroup.add(baserb);
                    basepanell.add(baserb);
                    i++;
                }

            }
             return basepanell;
        }



}


