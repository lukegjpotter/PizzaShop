/**
 * 24/February/2010 Persistence Completed.
 * 15/January/2010: Class Created.
 */

package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Luke GJ Potter
 *
 */

@Entity
@Table (name = "PIZZA")
public class Pizza extends Product implements Serializable {
	
	//Declare Variables
	private static final long serialVersionUID = 1L;
	private int size;
	private BaseStyle baseStyle;
	private Sauce sauce;
	private List <Toping> toping;
	
	//Default Constructor
	public Pizza () {

            toping = new ArrayList <Toping> ();
        }
	
	//Constructor for Custom Pizza
	public Pizza (int s, BaseStyle bs, Sauce sau, List <Toping> t) {

                setName("Custom Pizza");
		setSize(s);
		setBaseStyle(bs);
		setSauce(sau);
                toping = new ArrayList <Toping> ();
                setToping(t);
                setDescription("A " + getSize() + " Inch Pizza with a \n"
                        + getBaseStyle() + " base and " + getSauce() + ".\nToppings: "
			+ printTopings());
                calculatePizzaPrice();
	}
	
	//Constructor that takes arguments
	public Pizza (String n, BaseStyle bs, Sauce sau, List <Toping> t) {

                super (n);
		setBaseStyle(bs);
		setSauce(sau);
                toping = new ArrayList <Toping> ();
                setToping(t);
		setDescription("A " + getSize() + " Inch Pizza with a "
                        + getBaseStyle() + " base and " + getSauce() + ".\nToppings: "
			+ printTopings());
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
	
	//Set Pizza's Description method
        @Override
	public void setDescription (String s) {
		
		super.setDescription(s);
	}

	//Get Pizza's Description method
        @Transient
        @Override
	public String getDescription() {
		
		return super.getDescription();
	}

	//Set Pizza's Size method
	public void setSize (int size) {
		
		this.size = size;
	}

	//Get Pizza's Size method
        @Transient
	public int getSize() {
		
		return size;
	}

	//Set Pizza's Base Style method
	public void setBaseStyle (BaseStyle baseStyle) {
		
		this.baseStyle = baseStyle;
	}

	//Get Pizza's Base Style method
        @JoinColumn
        @ManyToOne
	public BaseStyle getBaseStyle() {
		
		return baseStyle;
	}

	//Set Pizza's Sauce Type method
	public void setSauce (Sauce sauce) {
		
		this.sauce = sauce;
	}

	//Get Pizza's Sauce Type method
        @JoinColumn
        @ManyToOne
	public Sauce getSauce() {
		
		return sauce;
	}

	//Set Pizza's Topings method
	public void setToping (List <Toping> toping) {
		
		this.toping = toping;
	}

	//Get Pizza's Topings method
        @ManyToMany
        @JoinTable(
            name="PIZZA_TOPING",
            joinColumns=@JoinColumn(name="P_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="T_ID", referencedColumnName="ID")
        )
	public List <Toping> getToping() {
		
		return toping;
	}

        //A method to add a Toping to a Pizza
        public void addTopingToPizza (Toping t) {

            toping.add(t);
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

                calculatePizzaPrice();
		return super.getPrice();
	}

        //A method to calculate the price of a Pizza
        public void calculatePizzaPrice () {

            //Declare Variables
            double baseprice, topingsprice;

            //Set the Base Price
            if (size == 7) baseprice = 5;
            else if (size == 9) baseprice = 10;
            else if (size == 11) baseprice = 15;
            else baseprice = 20;

            //Set the Toping Price @ 50c/Toping
            topingsprice = toping.size()*0.5;

            //Assign the price
            setPrice(baseprice + topingsprice);
        }

        //A method to print out all the Topings in the List of Topings
        public String printTopings() {

            String top = toping.get(0).toString();

            for (int i = 1; i < toping.size(); i++)
                top += ", " + toping.get(i).getName();

            return top;
        }
	//To String Override method
        @Override
	public String toString() {

		return super.toString() + " " + getDescription() + " Price: £" + getPrice();
	}
}
