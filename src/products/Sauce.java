/**
 * 24/February/2010 Persistence Completed.
 * 15/January/2010: Class Created.
 */

package products;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "SAUCE")
public class Sauce extends Product implements Serializable {

	//Declare Variables
	private static final long serialVersionUID = 1L;
	
	//Default Constructor
	public Sauce () {}
	
	//Constructor that takes arguments
	public Sauce (String n) {
		
		super(n);
	}

	//Get ID method
	@Id
	@GeneratedValue
	@Override
	public long getID() {
		
		return super.getID();
	}
	
	//Set Product's Name method
	@Override
	public void setName (String name) {
		
		super.setName(name);
	}

	//Get Product's Name method
	@Column
	@Override
	public String getName() {
		
		return super.getName();
	}
	
	//Set Prodict's Price method
	@Override
	public void setPrice (double price) {
		
		super.setPrice(price);
	}

	//Get Product's Price method
	@Column
	@Override
	public double getPrice() {
		
		return super.getPrice();
	}

        //To String Override method
        @Override
	public String toString() {

		return super.toString();
	}
}
