/**
 * 24/February/2010 Persistence Completed.
 * 28/January/2010 Class Created
 */

package entity;

import orders.Order;
import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "CUSTOMER")
public class Customer implements Serializable {
	
    //Declare Variables
	private static final long serialVersionUID = 1L;
	private String number, name, address;
	private Order lastOrder;
	
	//Default Constructor
	public Customer() {}
	
	//Constructor that takes arguments
	public Customer (String num, String fn, String sn, String street, String city) {
		
		setNumber(num);
		setName(fn + " " + sn);
		setAddress(street + ", " + city);
	}
	
	//Set the Customer's Phone Number method
	public void setNumber (String number) {
		
		this.number = number;
	}
	
	//Get the Customer's Phone Number method
	@Id
	public String getNumber() {
		
		return number;
	}
	
	//Set the Customer's Name method
	public void setName(String name) {
		
		this.name = name;
	}

	//Get the Customer's Name method
	@Column
	public String getName() {
		
		return name;
	}
	
	//Set the Customer's Address method
	public void setAddress (String address) {
		
		this.address = address;
	}

	//Get the Customer's Address method
	@Column
	public String getAddress() {
		
		return address;
	}

	//Set the Customer's last Order method
	public void setLastOrder (Order lastOrder) {
		
		this.lastOrder = lastOrder;
	}

	//Get the Customer's last Order method
	@OneToOne
        @JoinColumn
	public Order getLastOrder() {
		
		return lastOrder;
	}

        //To String Override method
        @Override
	public String toString() {

		return number + " " + name + " " + address;
	}
}
