/**
 * 24/February/2010 Persistence Completed.
 * 27/January/2010 Class Created.
 */

package orders;

import java.io.Serializable;

import javax.persistence.*;
import products.Product;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "ORDERLINE")
public class OrderLine implements Serializable {

	//Declare Variables
	private static final long serialVersionUID = 1L;
	private long ID;
	private Product product;
        private String productName;
	private int quantity;
	private double subTotal;
	
	//Default Constructor
	public OrderLine () {
            
            setQuantity(0);
            setSubTotal(0);
        }
	
	//Constructor
	public OrderLine (int qty, Product p) {
		
		setProduct(p);
                setProductName(product.getName());
                setQuantity(qty);
		calculateSubTotal();
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

        //Set the Product's Name
        public void setProductName(String pn) {

            this.productName = pn;
        }

        //Get the Product's Name
        @Column
        public String getProductName() {

            return productName;
        }
	//Set a Product for an Order Line method
	public void setProduct (Product product) {
		
		this.product = product;
	}

	//Get a Product for an Order Line method
        @Transient
	public Product getProduct() {
		
		return product;
	}
	
	//Set Quantity method
	public void setQuantity (int quantity) {
		
		this.quantity = quantity;
	}

	//Get Quantity method
	@Column
	public int getQuantity() {
		
		return quantity;
	}

	//Set Sub-Total method
	public void setSubTotal (double subTotal) {
		
		this.subTotal = subTotal;
	}

	//Get Sub-Total method
	@Column
	public double getSubTotal() {
		
		calculateSubTotal();
		return subTotal;
	}
	
	//Calculate Sub-Total method
	public void calculateSubTotal() {
		
		setSubTotal(quantity * product.getPrice());
	}
	
	//A To String method
	@Override
	public String toString() {

            if (product.getName().equals("Custom Pizza"))
                return getQuantity() + " * " + product.getDescription() +  " Price: £" + getSubTotal() + "\n";
            else
		return getQuantity() + " * " + getProductName() +  " Price: £" + getSubTotal() + "\n";
	}
}
