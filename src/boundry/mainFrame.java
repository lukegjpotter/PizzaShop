package Boundry;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;



import products.*;
import employees.*;
import entity.Customer;
import control.Queries;
import orders.*;





@SuppressWarnings("serial")
public class mainFrame extends JFrame implements ActionListener, ItemListener {
                                           
	
	static mainFrame myGUI;
	JFrame frame;
	
	
	
	JMenuBar menuBar;
	JMenu menu1, menu2;
        JMenuItem admin;
   

	JTextArea info;	
	JPanel infopanel;
	JButton logout;
	JButton cancelorder;
	
	
	JPanel currorder;
	JLabel corder;
	JButton confirm;
	JTextArea order;
	JScrollPane scrollPaneorder;
	
	JTabbedPane prods;
	JTabbedPane pizzasize;
	JPanel pizzapanel1;
	JPanel pizzapanel2;
	
	JPanel pizzapanel5;
	JPanel pizzapanel6;
	JPanel pizzapanel7;


        // Custom pizza
        JPanel sizepanel;
        JPanel Basepanel;
        JPanel Saucepanel;
        JPanel Toppanel;

        List <JRadioButton> sizegroupp;
        
        ButtonGroup sizegroup;

        JButton addpizzabutton;

        ButtonGroup basegroup;
        ButtonGroup saucegroup;
        List <Checkbox> cblist;

        //Menu Pizza
        JPanel menupizza;
        JPanel menupizzapanel;
        JButton addpizzabutton2;

        //side
        JPanel side;
        JPanel pan ;
        JButton addsidebutton;
        List <Checkbox> sideslist;
        List <SideOrder> so;
        
        //Drink
        JPanel drink;
        JButton adddrinkbutton;
        List <Checkbox> drinklist;
        List <Drink> dr;
        //Desert
        JPanel desert;
        JButton adddesertbutton;
         List <Desert> ds;
         List <Checkbox> desertlist;


	JPanel sysstatus;
	JLabel sysstatlabel;
	JButton clear;
	JTextArea sysstat;
	JScrollPane scrollPanesysstat;
        JScrollPane scrollPaneinfo;
	
        


	ShopEmployee emp;
	Customer cus;
        Queries q;

        List <BaseStyle> base;
        List <Sauce> sauce;
        List<Toping> topings;

        Order O;

        JPanel toppanel;
       
	
	public mainFrame(ShopEmployee e, Customer cu)
	{
		

            emp=e;
            cus = cu;
            q= new Queries();
            O = new Order();

            frame = new JFrame("5 star pizza");

            //layout manager added to container
            FlowLayout fl = new FlowLayout();
            Container cont = getContentPane();
            cont.setLayout(fl);
            //cont.setPreferredSize(new Dimension(1100,800));

            //Menu Bar
            menuBar = new JMenuBar();
            menu1 = new JMenu("File");
            menu2 = new JMenu("Tools");
            menuBar.add(menu1);
            menuBar.add(menu2);
            admin = new JMenuItem("Admin");


            admin.addActionListener(this);

            menu2.add(admin);


            //Information Panel
            infopanel = new JPanel();

            infopanel.setLayout(new BorderLayout());

            info = new JTextArea(2,32);

            info.setEditable(false);
            Font font = new Font("TimesRoman", Font.BOLD, 24);
            info.setFont(font);
            info.append(getInfo());

            logout = new JButton("   Log Out   ");
            logout.addActionListener(this);
            cancelorder = new JButton(" Cancel Order ");
            cancelorder.addActionListener(this);

            infopanel.add(info, BorderLayout.LINE_START);
            infopanel.add(logout,BorderLayout.CENTER);
            infopanel.add(cancelorder,BorderLayout.LINE_END);

            //Current Order Panel

            currorder = new JPanel();
            currorder.setLayout(new BorderLayout());
            
            currorder.setSize(275, 300);

            corder = new JLabel("Current Order") ;
            corder.setFont(font);
            confirm = new JButton("Confirm") ;
            confirm.addActionListener(this);


            order = new JTextArea(20,20);
            order.setEditable(false);
            scrollPaneinfo = new JScrollPane(order);


            currorder.add(corder, BorderLayout.LINE_START);
            currorder.add(confirm,BorderLayout.LINE_END);
            currorder.add(scrollPaneinfo,BorderLayout.PAGE_END);


            //System Status
            sysstatus = new JPanel();
            sysstatus.setLayout(new BorderLayout());

            sysstatus.setSize(275, 300);
            sysstatlabel = new JLabel(" System  Status ") ;
            sysstatlabel.setFont(font);
            clear = new JButton("  Clear  ") ;
            clear.addActionListener(this);


            sysstat = new JTextArea(20,20);
            sysstat.setEditable(false);


            scrollPanesysstat = new JScrollPane(sysstat);





            sysstatus.add(sysstatlabel, BorderLayout.LINE_START);
            sysstatus.add(clear,BorderLayout.LINE_END);
            sysstatus.add(scrollPanesysstat,BorderLayout.PAGE_END);



            //Tabbed Pane
            prods = new JTabbedPane();


            pizzasize = new JTabbedPane();
            pizzasize.setPreferredSize(new Dimension(825,600));
            pizzasize.setSize(200, 125);
            pizzapanel1 = new JPanel();
            pizzapanel2 = new JPanel();

            pizzapanel5 = new JPanel();
            pizzapanel6 = new JPanel();
            pizzapanel7 = new JPanel();


            //************************** Custom Pizza **********************


            JPanel sizelabel = new JPanel();
            sizelabel.add(new JLabel("Size :"));
            sizegroup = new ButtonGroup();

            JRadioButton seven = new JRadioButton("7\"",true);
            seven.setActionCommand("7");
            JRadioButton nine = new JRadioButton("9\"");
            nine.setActionCommand("9");
            JRadioButton eleven = new JRadioButton("11\"");
            eleven.setActionCommand("11");
            JRadioButton sixteen = new JRadioButton("16\"");
            sixteen.setActionCommand("16");

            sizegroup.add(seven);
            sizegroup.add(nine);
            sizegroup.add(eleven);
            sizegroup.add(sixteen);

            sizepanel = new JPanel();
            sizepanel.add(seven);
            sizepanel.add(nine);
            sizepanel.add(eleven);
            sizepanel.add(sixteen);

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
            pizzapanel1.add(sizelabel,pp);
            
            
            pp.gridx = 1;
            pp.gridy = 0;
            pizzapanel1.add(sizepanel,pp);
                    

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

            // ************************ Menu Pizzas ************************

            addpizzabutton2 = new JButton("Add Item");
            addpizzabutton2.addActionListener(this);

            menupizzapanel = new JPanel();
            JLabel munuplabel =new JLabel("Menu Pizza:");

            menupizza = getmenuPizza();

            JPanel topspanel = getToppings();

            GridBagConstraints mp = new GridBagConstraints();
            menupizzapanel.setLayout(new GridBagLayout());

            mp.gridx = 0;
            mp.gridy = 0;
            menupizzapanel.add(munuplabel,mp);

            mp.gridx = 0;
            mp.gridy = 1;
            menupizzapanel.add(menupizza,mp);

            mp.gridx = 0;
            mp.gridy = 2;
            menupizzapanel.add(topspanel,mp);

            mp.gridx = 0;
            mp.gridy = 3;
            menupizzapanel.add(addpizzabutton2,mp);


            //**************************** Sides *******************************

            addsidebutton = new JButton("Add Item");
            addsidebutton.addActionListener(this);

            JPanel sidepanel = new JPanel();
            JLabel sidelabel =new JLabel("Sides:");

            side = getSide();


            GridBagConstraints s = new GridBagConstraints();
            sidepanel.setLayout(new GridBagLayout());

            pp.gridx = 0;
            pp.gridy = 0;
            sidepanel.add(sidelabel,s);

            pp.gridx = 1;
            pp.gridy = 0;
            sidepanel.add(side,s);

            pp.gridx = 2;
            pp.gridy = 0;
            sidepanel.add(addsidebutton,s);

            //*************************   Drinks   *****************************
            
            adddrinkbutton = new JButton("Add Item");
            adddrinkbutton.addActionListener(this);

            JPanel drinkpanel = new JPanel();
            JLabel drinklabel =new JLabel("Drink:");

            drink = getDrink();


            GridBagConstraints d = new GridBagConstraints();
            drinkpanel.setLayout(new GridBagLayout());

            d.gridx = 0;
            d.gridy = 0;
            drinkpanel.add(drinklabel,d);

            d.gridx = 0;
            d.gridy = 1;
            drinkpanel.add(drink,d);

            d.gridx = 0;
            d.gridy = 2;
            drinkpanel.add(adddrinkbutton,d);
            
            
            //*********************** Desert  **********************************
            adddesertbutton = new JButton("Add Item");
            adddesertbutton.addActionListener(this);

            JPanel desertpanel = new JPanel();
            JLabel desertlabel =new JLabel("Desert:");

            desert = getDesert();


            GridBagConstraints des = new GridBagConstraints();
            desertpanel.setLayout(new GridBagLayout());

            des.gridx = 0;
            des.gridy = 0;
            desertpanel.add(desertlabel,des);

            des.gridx = 0;
            des.gridy = 1;
            desertpanel.add(desert,des);

            des.gridx = 0;
            des.gridy = 2;
            desertpanel.add(adddesertbutton,des);





            //******************************************************************
            
            
            
            
            pizzasize.setFont(font);
            pizzasize.addTab("Custom Pizza", pizzapanel1);
            pizzasize.addTab("Menu Pizza", menupizzapanel);
            pizzasize.setTabLayoutPolicy(1);

            prods.setFont(font);
            prods.addTab("Pizza", pizzasize);
            prods.addTab("Sides",sidepanel);
            prods.addTab("Drinks",drinkpanel);
            prods.addTab("Deserts",desertpanel);
            prods.setTabLayoutPolicy(1);


            


            GridBagConstraints c = new GridBagConstraints();

            JPanel p = new JPanel();
            p.setLayout(new GridBagLayout());

            c.gridheight=1;
            c.gridx = 0;
            c.gridy = 0;

            p.add(infopanel,c);



            c.gridx = 2;
            c.gridy = 0;
            c.gridwidth= 1/4;
            c.gridheight= 2;

            p.add(currorder,c);


            c.gridx = 0;
            c.gridy = 1;
            c.gridheight=4;
            c.gridwidth= 1;
            p.add(prods,c);


            c.gridx = 1;
            c.gridy = 3;
            c.gridwidth= 1/4;
            c.gridheight= 2;
            p.add(sysstatus,c);


            cont.add(p);
            cont.setVisible(true);

            frame.setJMenuBar(menuBar);
            frame.add(cont);



            frame.pack();
            frame.setVisible(true);
            frame.setSize(1150, 800);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);

            frame.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent winEvt) {
                    
                    System.exit(0);

                    }

                });
                
		
		
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == logout )
                {

                    
                    loginGUI log = new loginGUI();
                    
                    frame.dispose();
                   

                }

                else if (ae.getSource()==clear)
                {
                    long time = System.currentTimeMillis();
                    Date date = new Date(System.currentTimeMillis());
                    sysstat.setText("Cleared at : "+ date);
                }


                else if(ae.getSource()==addpizzabutton)
                {

                    String sizee = sizegroup.getSelection().getActionCommand();

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

                   

                    
                    Pizza p = new Pizza(Integer.parseInt(sizee),base.get(Integer.parseInt(basee)),sauce.get(Integer.parseInt(saucee)),topss);
                    sysstat.append("\nCustomer "+ cus.getName()+ "\nOrdered " + p.toString()+ "\n" );

                    OrderLine ol = new OrderLine(1,p);
                    O.addOrderLineToOrder(ol);

                    order.append(ol.toString()+"\n");

                    Basepanel = getBases();
                    Basepanel.revalidate();
                    Basepanel.repaint();
                    Saucepanel = getSauces();
                    Saucepanel.revalidate();
                    Saucepanel.repaint();
                    Toppanel = getToppings();
                    Toppanel.revalidate();
                    Toppanel.repaint();
                       
                }

                else if (ae.getSource()==admin)
                {
                    adminFrame adminf = new adminFrame();
                }

                else if (ae.getSource() == confirm)
                {
                    driver.cs.addOrder(O);
                    customerVerification cv = new customerVerification(emp);
                    frame.dispose();
                }

                else if (ae.getSource() == addsidebutton)
                {

                    
                    List <SideOrder> side = new ArrayList();
                    for(Checkbox s :sideslist)
                    {


                        if (s.getState()==true)
                        {
                            int index = sideslist.indexOf(s);

                            side.add(so.get(index));

                        }

                    }
                    for (SideOrder soo : side)
                    {
                        OrderLine ol = new OrderLine(1,soo);
                        O.addOrderLineToOrder(ol);
                        order.append(ol.toString()+"\n");
                    }
                    
                    

                }

                else if (ae.getSource()==adddrinkbutton)
                {
                    List <Drink> drink = new ArrayList();
                    for(Checkbox s :drinklist)
                    {


                        if (s.getState()==true)
                        {
                            int index = drinklist.indexOf(s);

                            drink.add(dr.get(index));

                        }

                    }
                    for (Drink d : drink)
                    {
                        OrderLine ol = new OrderLine(1,d);
                        O.addOrderLineToOrder(ol);
                        order.append(ol.toString()+"\n");
                    }
                }

                else if (ae.getSource()==adddesertbutton)
                {
                    List <Desert> desert = new ArrayList();
                    for(Checkbox s :desertlist)
                    {


                        if (s.getState()==true)
                        {
                            int index = desertlist.indexOf(s);

                            desert.add(ds.get(index));

                        }

                    }
                    for (Desert d : desert)
                    {
                        OrderLine ol = new OrderLine(1,d);
                        O.addOrderLineToOrder(ol);
                        order.append(ol.toString()+"\n");
                    }
                }
		
	}
	

	
	public String getInfo()
	{
		return  "Logged in as : "+emp.getEmployeeName()+"\n"+"Customer      : "+ cus.getName();
	}
        
        public JPanel getToppings()
        {
            // 
                topings = q.returnAllTopings ();
                toppanel = new JPanel();
                toppanel.setLayout(new GridLayout((int)Math.floor(topings.size()/3),3));

                cblist = new <Checkbox> ArrayList();
                for (Toping tops : topings)
                {
                    if(tops.getName().equals("Cheese"))
                    {
                        Checkbox cb = new Checkbox(tops.getName(),null,true);
                        cb.setName(tops.getName());
                        
                        cb.addItemListener(this);
                        cblist.add(cb);
                        toppanel.add(cb);
                    }
                    else
                    {
                        Checkbox cb = new Checkbox(tops.getName(),null,false);
                        cb.setName(tops.getName());
                        cb.addItemListener(this);
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


        public JPanel getmenuPizza()
        {
            JPanel custom = new JPanel();
            custom.setLayout(new GridBagLayout());
            List <Pizza> piz = q.returnAllPizzas();

            int i=0;
            System.out.println("getmenuPizza being called");
            for(Pizza p : piz)
            {

                Checkbox cb1 = new Checkbox("Choose Item");

                pan = new JPanel();
                JLabel lab = new JLabel("Name : "+p.getName());
                System.out.println(p.getName());
                JLabel baselab = new JLabel("Base : "+p.getBaseStyle().getName());

                JPanel toppan = new JPanel();

                for(Toping t : p.getToping())
                {
                    Checkbox cb = new Checkbox(t.getName(),null,true);
                    cb.setName(t.getName());
                    toppan.add(cb);
                }
                
                GridBagConstraints cc = new GridBagConstraints();
                pan.setLayout(new GridBagLayout());
                
                
                cc.gridx=0;
                cc.gridy=i;
                pan.add(cb1,cc);
                
                cc.gridx=1;
                cc.gridy=i;
                pan.add(lab,cc);

                cc.gridx=2;
                cc.gridy=i;
                pan.add(baselab,cc);

                cc.gridx=3;
                cc.gridy=i;
                pan.add(toppan,cc);

                cc.gridx=0;
                cc.gridy=i;
                custom.add(pan,cc);
                i++;
            }
            
            return custom;
        }

        public JPanel getSide()
        {
            JPanel sides = new JPanel();

            sideslist = new ArrayList();
            
            
             so = q.returnAllSideOrders();
            sides.setLayout(new GridLayout(3,(int)Math.floor(so.size()/3)));
            int i= 0;
            for(SideOrder s : so)
            {
                Checkbox cb = new Checkbox("Choose Item");

                sideslist.add(cb);
                JPanel pan = new JPanel();
                JLabel lab = new JLabel("Name : "+s.getName());
                JLabel desclab = new JLabel("Description : "+s.getDescription());
                JLabel price = new JLabel("Price :  €"+Double.toString(s.getPrice()));

                GridBagConstraints cc = new GridBagConstraints();
                pan.setLayout(new GridBagLayout());

                cc.gridx=i;
                cc.gridy=0;
                pan.add(cb,cc);

                cc.gridx=i;
                cc.gridy=1;
                pan.add(lab,cc);

                cc.gridx=i;
                cc.gridy=2;
                pan.add(desclab,cc);

                cc.gridx=i;
                cc.gridy=3;
                pan.add(price,cc);
                i++;
                
                sides.add(pan);
            }
            
            
            return sides;
        }

        public JPanel getDrink()
        {
            JPanel sides = new JPanel();

             drinklist = new ArrayList();
             dr = q.returnAllDrinks ();

            int i= 0;
            for(Drink d : dr)
            {
                Checkbox cb = new Checkbox(d.getName());
                cb.addItemListener(this);
                drinklist.add(cb);
//                cb.setState(false);
//                cb.setName(d.getName());
                sides.setLayout(new GridLayout(3,(int)Math.floor(dr.size()/3)));
                pan = new JPanel();
                JLabel lab = new JLabel("Name : "+ d.getName());
                JLabel desclab = new JLabel( "Description : "+d.getDescription());
                JLabel sizelab = new JLabel( "Size : "+d.getSize()+ " L");
                JLabel price = new JLabel("Price : €"+Double.toString(d.getPrice()));

                GridBagConstraints cc = new GridBagConstraints();
                pan.setLayout(new GridBagLayout());



                cc.gridx=0;
                cc.gridy=i;
                pan.add(cb);

                cc.gridx=i;
                cc.gridy=1;
                pan.add(lab,cc);

                cc.gridx=i;
                cc.gridy=2;
                pan.add(desclab,cc);

                cc.gridx=i;
                cc.gridy=3;
                pan.add(sizelab,cc);

                cc.gridx=i;
                cc.gridy=4;
                pan.add(price,cc);
                

                
                sides.add(pan);

                i++;
            }

            return sides;
        }

        public JPanel getDesert()
        {
            JPanel desert = new JPanel();
            

            ds = q.returnAllDeserts ();

            desert.setLayout(new GridLayout(3,(int)Math.floor(ds.size()/3)));
            int i= 0;
            for(Desert d : ds)
            {
                Checkbox cb = new Checkbox(d.getName());
                desertlist = new ArrayList();
                desertlist.add(cb);
                JPanel pan = new JPanel();
                JLabel lab = new JLabel("Name : "+ d.getName());
                JLabel desclab = new JLabel( "Description : "+d.getDescription());
                JLabel sizelab = new JLabel( "Size : "+d.getSize());
                JLabel price = new JLabel("Price : €"+Double.toString(d.getPrice()));

                JTextArea qty = new JTextArea(1,3);

                GridBagConstraints cc = new GridBagConstraints();
                pan.setLayout(new GridBagLayout());

                cc.gridx=i;
                cc.gridy=0;
                pan.add(cb,cc);
                
                cc.gridx=i;
                cc.gridy=1;
                pan.add(lab,cc);

                cc.gridx=i;
                cc.gridy=2;
                pan.add(desclab,cc);

                cc.gridx=i;
                cc.gridy=3;
                pan.add(sizelab,cc);
               
                cc.gridx=i;
                cc.gridy=4;
                pan.add(price,cc);

                cc.gridx=i;
                cc.gridy=5;
                pan.add(qty,cc);
                


                
                desert.add(pan);
                i++;
            }

            return desert;
        }

        @Override
        public void itemStateChanged(ItemEvent l) {

            if(l.getStateChange() == ItemEvent.SELECTED)
            {
               String  c = l.getItem().toString();
               System.out.println("source to string "+c);


               for (Checkbox b : cblist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(true);
                   }
               }

               for (Checkbox b: sideslist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(true);
                   }
               }

               for (Checkbox b: drinklist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(true);
                   }
               }

               for (Checkbox b: desertlist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(true);
                   }
               }
               
            }

            else if(l.getStateChange() == ItemEvent.DESELECTED)
            {
               String  c = l.getItem().toString();
               System.out.println("source to string "+c);


               for (Checkbox b : cblist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(false);
                   }
               }

               for (Checkbox b: sideslist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(false);
                   }
               }

               for (Checkbox b: drinklist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(false);
                   }
               }

               for (Checkbox b: desertlist)
               {
                   if(b.getName().equalsIgnoreCase(c))
                   {
                       b.setState(false);
                   }
               }

            }

    }



}


