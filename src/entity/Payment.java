/*
 * 28/February/2010 Class Created.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import orders.Order;
import employees.DeliveryEmployee;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "PAYMENT")
public class Payment implements Serializable {

    //Declare Variables
    private long ID;
    private DeliveryEmployee delemp;
    private Order order;
    private Date time;

    //Default Constructor
    public Payment () {}

    //Constructor that takes arguements
    public Payment (DeliveryEmployee del, Order ord) {

        time = new Date();
        time.setTime(System.currentTimeMillis());

        setDelEmp(del);
        setOrder(ord);
        setTime(time);
    }

    //Set ID method
    public void setID (long ID) {

        this.ID = ID;
    }

    //Get ID method
    @Id
    @GeneratedValue
    public long getID () {

        return ID;
    }

    //Set Delivery Employee's ID method
    public void setDelEmp (DeliveryEmployee de) {

        this.delemp = de;
    }

    //Get Delivery Employee's ID method
    @JoinColumn
    @ManyToOne
    public DeliveryEmployee getDelEmp () {

        return delemp;
    }

    //Set Order's ID method
    public void setOrder (Order ord) {

        this.order = ord;
    }

    //Get Order's ID method
    @JoinColumn
    @ManyToOne
    public Order getOrder () {

        return order;
    }

    //Set Time method
    public void setTime (Date d) {

        this.time = d;
    }

    //Get Time method
    @Column (name = "LODGEMENT_TIME")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getTime() {

        return time;
    }

    //To String Override method
    @Override
    public String toString() {

            return delemp + " lodged payment for order " + order + " at " + time;
    }
}
