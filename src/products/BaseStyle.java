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
@Table (name = "BASESTYLE")
public class BaseStyle extends Product implements Serializable {

	//Declare Variables
	private static final long serialVersionUID = 1L;
	private String description;
	
	//Default Constructor
	public BaseStyle () {}
	
	//Constructor that takes arguments
	public BaseStyle (String n, String desc) {
		
		super(n);
		description = desc;
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
	
	//Set Base Style Description Method
        @Override
	public void setDescription (String desc) {
		
		this.description = desc;
	}
	
	//Get Base Style Description Method
        @Override
	@Column
	public String getDescription () {
		
		return description;
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
