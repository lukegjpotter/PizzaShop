/**
 * 25/Febuary/2010 Persists Added
 * 16/February/2010 Class Created.
 */
package control;

import javax.persistence.*;
import employees.*;
import entity.*;
import products.*;

/**
 * @author Luke GJ Potter
 * @author John Farrell
 */

public class DatabasePopulation {

    //Creates a new instance of DataBasePopulation
    public DatabasePopulation() {}

    //Main method
    public static void main(String[] args) {

        // Create the EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pizza Shop");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Persist Sauces
        for(Sauce s: sauces) {
            em.persist(s);
        }

        //Persist Base Styles
        for(BaseStyle b: bases) {
            em.persist(b);
        }

        //Persist Topings
        for(Toping t: topings) {
            em.persist(t);
        }

        //Persist Drinks
        for(Drink d: drinks) {
            em.persist(d);
        }
        //Persist Deserts
        for(Desert de: deserts) {
            em.persist(de);
        }

        //Persist SideOrders
        for(SideOrder so: sides) {
            em.persist(so);
        }

        //Persist Customers
         for(Customer c: customers) {
            em.persist(c);
        }

        //Persist Shop Employees
         for(ShopEmployee sh: shop) {
            em.persist(sh);
        }

        //Persist Delivery Employees
        for(DeliveryEmployee del: delivery) {
            em.persist(del);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    private static DeliveryEmployee[] delivery = new DeliveryEmployee[]{
        new DeliveryEmployee ("Jack", "Michealson",8.65 , "03 RN 2018", 1234),
        new DeliveryEmployee ("James", "Sawyer",8.65 , "02 G 1055", 4321),
        new DeliveryEmployee ("Hugo", "Rameriaz",8.65 , "98 MO 3398", 3412),

    };

    private static ShopEmployee[] shop = new ShopEmployee[]{
        new ShopEmployee("Peter", "Jenkins", 8.65, "password1"),
        new ShopEmployee("Joe", "Jenkins", 8.65, "password2"),
        new ShopEmployee("Paul", "Jenkins", 8.65, "password3")
    };

    private static Customer[] customers= new Customer[]{
       new Customer ("0851234567", "John", "Smith", "245 Laurel Park", "Galway"),
       new Customer ("0851236745", "Joe", "Bloggs", "160 Laurel Park", "Galway"),
       new Customer ("0851234765", "John", "Farrell", "11 Carraig Liath", "Galway"),
       new Customer ("0854567123", "Paul", "Wilson", "3 Raleigh Row", "Galway"),
       new Customer ("0854512367", "Peter", "O'Toole", "38 Ros Gael", "Galway"),
    };

    private static SideOrder[] sides= new SideOrder[]{
        new SideOrder("BBQ Chicken Wings ", "BBQ Chicken Wings", 5.00),
        new SideOrder("Chicken Dippers ", "Chicken Dippers ", 5.00),
        new SideOrder("Garlic Bread ", "Garlic Bread", 3.50),
        new SideOrder("Potato Wedges ", "Garlic Bread ", 2.50),
    };

    private static Desert[] deserts= new Desert[]{
        new Desert("Ben & Jerry's - Chocolate Fudge Brownie Vegetarian ", "Ben & Jerry's - Chocolate Fudge Brownie Vegetarian ", 0.15, 3.50),
        new Desert("Ben & Jerry's - Cookie Dough ", "Ben & Jerry's - Cookie Dough", 0.15, 3.50),
        new Desert("Ben & Jerry's - Caramel Chew Chew", "Ben & Jerry's - Caramel Chew Chew", 0.15, 3.50),
        new Desert("Ben & Jerry's - Vanilla", "Ben & Jerry's - Vanilla", 0.15, 3.50),
        new Desert("Waffles", "Waffles", 1.00, 4.00),
        new Desert("Cookies", "Cookies", 1.00, 4.00),
    };

    private static Drink[] drinks = new Drink[]{
        new Drink("Coca-Cola", "Coca-Cola 2L", 2.00, 2.50),
        new Drink("Diet Coca-Cola", "Diet Coca-Cola 2L", 2.00, 2.50),
        new Drink("Water", "Water 500ml", 0.50, 2.00),
        new Drink("Fanta", "Fanta Can", 0.33, 1.50),
        new Drink("7-up", "7-up Can", 0.33, 1.50),
        new Drink("Dr. Pepper", "Dr. Pepper Can", 0.33, 1.50),
        new Drink("Coca-Cola", "Coca-Cola Can", 0.33, 1.50),
        new Drink("Diet Coca-Cola", "Diet Coca-Cola Can", 0.33, 1.50),
    };

    private static Toping[] topings = new Toping[] {

        //The ID is generated automatically, just input the name
        new Toping ("Cheese"), new Toping ("Ham"), new Toping ("Sausage"),
        new Toping ("Meatballs"), new Toping ("Chicken"), new Toping ("Cajon Chicken"),
        new Toping ("Ground Beef"),new Toping ("Pepperoni"),new Toping ("Smoky Bacon"),
        new Toping ("Tuna"),new Toping ("Anchovies"),new Toping ("Salami"),
        new Toping ("Tomato"),new Toping ("Sweetcorn"),
        new Toping ("Pineapple"),new Toping ("Onions"),new Toping ("Olives"),
        new Toping ("Mushrooms"),new Toping ("Jalapeno Peppers"),new Toping ("Mixed Peppers"),
    };

    private static Sauce[] sauces = new Sauce[]{
        new Sauce ("Tomato"),
        new Sauce ("Barbeque"),
        new Sauce ("Sundried Tomato and Garlic Sauce ")
    };

    private static BaseStyle[] bases = new BaseStyle[]{
        new BaseStyle("Thin Crust","Thin Crust"),
        new BaseStyle("Deep Pan","Deep Pan"),
        new BaseStyle("Regular","Regular"),
    };
}