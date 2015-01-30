/**
 * 24/February/2010 Persistence Completed.
 * 27/January/2010 Class Created.
 */

package orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "ORDERS")
public class Order implements Serializable {
	
    //Declare Variables
	private static final long serialVersionUID = 1L;
	private long ID;
	private List <OrderLine> ol;
	private double totalPrice;
	private boolean isConfirmed; 
	
	//Default Constructor
	public Order() 
        {
            totalPrice = 0;
            ol = new ArrayList <OrderLine> ();
            isConfirmed = false;
        }
	
	//Constructor that takes arguments
	public Order (OrderLine ol) {

                this.ol = new ArrayList <OrderLine> ();
		addOrderLineToOrder(ol);
		setTotalPrice(ol.getSubTotal());
		setConfirmed(false);
	}
	
	//Set ID method
	public void setID (long iD) {
		
		ID = iD;
	}

	//Get ID method
	@Id
	@GeneratedValue
	public long getID() {
		
		return ID;
	}

	//Set OrderLine method
	public void setOl (List <OrderLine> ol) {
		
		this.ol = ol;
	}

	//Get OrderLine method
	@ManyToMany
        @JoinTable(
            name="ORD_ORDERLINE",
            joinColumns=@JoinColumn(name="ORD_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="OLIN_ID", referencedColumnName="ID")
        )
	public List <OrderLine> getOl() {

            return ol;
	}

        //A method to add an OrderLine
        public void addOrderLineToOrder (OrderLine o) {

            totalPrice += o.getSubTotal();
            this.ol.add(o);
        }

	//Set an Order's Total Price
	public void setTotalPrice (double totalPrice) {
		
		this.totalPrice = totalPrice;
	}

	//Get an Order's Total Price
	@Column
	public double getTotalPrice() {
		
		return totalPrice;
	}

	//Set the isConfirmed Variable method
	public void setConfirmed (boolean isConfirmed) {
		
		this.isConfirmed = isConfirmed;
	}

	//Get the value of the isConfirmed Variable method
	@Column
	public boolean isConfirmed() {
		
		return isConfirmed;
	}
	
	//Confirm Order method
	public void confirmOrder() {
		
		setConfirmed(true);
	}

        //A To String method
        @Override
        public String toString() {

            return ol.toString() + totalPrice;
        }
}
