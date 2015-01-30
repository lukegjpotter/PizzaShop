/**
 * 16/February/2010 Persistence Completed.
 * 27/January/2010 Class Created.
 */

package products;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "DRINK")
public class Drink extends Product implements Serializable {

	//Declare Variables
	private static final long serialVersionUID = 1L;
	private double size;

        public Drink() {}
	
	//Constructor
	public Drink(String n, String desc, double s, double p) {

		super(n, desc, p);
		setSize(s);
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
	
	//Set Drink Size method
	public void setSize (double size) {
		
		this.size = size;
	}

	//Get Drink Size method
	@Column (name = "Liters")
	public double getSize() {
		
		return size;
	}
	
	//Set Side Description method
	@Override
	public void setDescription (String description) {
		
		super.setDescription(description);
	}

	//Get Side Description method
	@Column
	@Override
	public String getDescription() {
		
		return super.getDescription();
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

		return super.toString() + " " + getDescription() + " " + getSize() + "L Price: £" + getPrice();
	}
}
