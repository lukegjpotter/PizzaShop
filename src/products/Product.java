/**
 * 24/February/2010 Persistence Completed.
 * 27/January/2010 Class Created.
 */

package products;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@MappedSuperclass
public abstract class Product implements Serializable {
	
	//Declare Variables
	private static final long serialVersionUID = 1L;
	private long ID;
	private String name, description;
	private double price;
	
	//Default Constructor
	public Product () {}
	
	//Constructor that only takes in a name
	public Product (String n) {
		
		setName(n);
	}

        //Constructor that takes only Name and Price
        public Product (String n, double p) {

            setName(n);
            setPrice(p);
        }
        
	//Constructor that takes arguments
	public Product (String n, String desc, double p) {
		
		setName(n);
                setDescription(desc);
		setPrice(p);
	}

	//Set ID method
	public void setID(long iD) {
		
		ID = iD;
	}

	//Get ID method
	@Id
	@GeneratedValue
	public long getID() {
		
		return ID;
	}

	//Set Product's Name method
	public void setName (String name) {
		
		this.name = name;
	}

	//Get Product's Name method
	@Column
	public String getName() {
		
		return name;
	}

	//Set Prodict's Price method
	public void setPrice (double price) {
		
		this.price = price;
	}

	//Get Product's Price method
	@Column
	public double getPrice() {
		
		return price;
	}

        //Set Side Description method
	public void setDescription (String description) {

		this.description = description;
	}

	//Get Side Description method
	@Column
	public String getDescription() {

		return description;
	}

        //A To String method
        @Override
        public String toString() {

            return name;
        }
}
