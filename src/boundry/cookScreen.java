

package Boundry;

/**
 *
 * @author John Farrell 03650031
 */


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import orders.*;

public class cookScreen implements ActionListener{


    JFrame frame;
    JPanel panelupdate;
    JButton button;
    JPanel panel;
   
    JScrollPane scrollPaneorder;
    private List <JButton> paneltrack = new ArrayList <JButton> ();


    public cookScreen()
    {
        frame = new JFrame("5 Star Pizza Cook Screen");

        
        panelupdate = new JPanel() ;
        scrollPaneorder= new JScrollPane(panelupdate);
//        panelupdate.setLayout(new BorderLayout());

        scrollPaneorder = new JScrollPane();

//        panelupdate.add(scrollPaneorder);
        

        frame.add(panelupdate);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
    }

    public void addOrder(Order o)
    {


        panel = new JPanel();
        JTextArea ta = new JTextArea(10,50);
        List <OrderLine>ol =o.getOl();
        
        for(OrderLine oline :ol)
        {
            ta.append(oline.toString());
        }
        
        
        button = new JButton("Order Finished");
        button.addActionListener(this);
        
        paneltrack.add(button);
        
        
        panel.add(ta);
        panel.add(button);

        panelupdate.setLayout(new GridBagLayout());
        GridBagConstraints pp = new GridBagConstraints();
        

        System.out.println(paneltrack.size());


        pp.gridx=0;
        pp.gridy=paneltrack.size();

        panelupdate.add(panel,pp);
        panelupdate.revalidate();
        panelupdate.repaint();
        
        

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        for(int i = 0; i< paneltrack.size();i++)
        {
            if (ae.getSource().equals(paneltrack.get(i)))
        
            {
                panelupdate.remove(paneltrack.get(i).getParent());

                panelupdate.revalidate();
                panelupdate.repaint();

            }
        
        }
        
    }

  
  
}
