/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import employees.*;
import entity.*;
import products.*;
/**
 * @author Luke GJ Potter
 *
 */

public class DBPOP {

    //BaseStyles
    private static BaseStyle thin = new BaseStyle("Thin Crust","Thin Crust");
    private static BaseStyle reg = new BaseStyle("Regular","Regular");
    private static BaseStyle deep = new BaseStyle("Deep Pan","Deep Pan");

    //Sauces
    private static Sauce tom = new Sauce ("Tomato");
    private static Sauce bbq = new Sauce ("Barbeque");
    private static Sauce sdt = new Sauce ("Sundried Tomato and Garlic Sauce ");

    //Toping
    private static Toping cheese = new Toping ("Cheese");
    private static Toping ham = new Toping ("Ham");
    private static Toping sausage = new Toping ("Sausage");
    private static Toping mb = new Toping ("Meatballs");
    private static Toping chick = new Toping ("Chicken");
    private static Toping cchick = new Toping ("Cajon Chicken");
    private static Toping gbeef = new Toping ("Ground Beef");
    private static Toping pep = new Toping ("Pepperoni");
    private static Toping sb = new Toping ("Smoky Bacon");
    private static Toping tuna = new Toping ("Tuna");
    private static Toping anch = new Toping ("Anchovies");
    private static Toping salami = new Toping ("Salami");
    private static Toping tomato = new Toping ("Tomato");
    private static Toping sweet = new Toping ("Sweetcorn");
    private static Toping pine = new Toping ("Pineapple");
    private static Toping onion = new Toping ("Onions");
    private static Toping olives = new Toping ("Olives");
    private static Toping mushroom = new Toping ("Mushrooms");
    private static Toping jpeper = new Toping ("Jalapeno Peppers");
    private static Toping mixpep = new Toping ("Mixed Peppers");

    //Toping Arrays
    private static Toping[] haw =  {cheese, ham, pine, mushroom};
    private static Toping[] ac = {cheese, pep};
    private static Toping[] del = {cheese, pep, onion, mushroom, sweet};
    private static Toping[] veg = {cheese, onion, pine, mushroom, sweet};
    private static Toping[] mdel = {cheese, pep, salami, sb, chick};

    //Topings Lists
    private static List <Toping> hawaiianT = new ArrayList <Toping>();
    private static List <Toping> americanCT = new ArrayList <Toping>();
    private static List <Toping> deluxT = new ArrayList <Toping>();
    private static List <Toping> vegT = new ArrayList <Toping>();
    private static List <Toping> mdeluxT = new ArrayList <Toping>();

    //Constructor
    public DBPOP () {

        //Populate Toping Lists
        addAllTopingsToList(hawaiianT, haw);
        addAllTopingsToList(americanCT, ac);
        addAllTopingsToList(deluxT, del);
        addAllTopingsToList(vegT, veg);
        addAllTopingsToList(mdeluxT, mdel);
    }

    //Main method
    public static void main (String[] args) {

        //Persist Pizzas
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pizza Shop");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Persist Pizzas
        for (Pizza p: pizzas) {
            em.persist(p);
        }

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
        for(DeliveryEmployee de: delivery) {
            em.persist(de);
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
        new Toping ("Mushrooms"),new Toping ("Jalapeno Peppers"),new Toping ("Mixed Peppers")
    };

    private static Sauce[] sauces = new Sauce[]{
        new Sauce ("Tomato"),
        new Sauce ("Barbeque"),
        new Sauce ("Sundried Tomato and Garlic Sauce ")
    };

    private static BaseStyle[] bases = new BaseStyle[]{
        new BaseStyle("Thin Crust","Thin Crust"),
        new BaseStyle("Deep Pan","Deep Pan"),
        new BaseStyle("Regular","Regular")
    };

    public static Pizza[] pizzas = new Pizza[]{
        new Pizza ("Hawaiian Classic", reg, tom, hawaiianT),
        new Pizza ("American Classic", thin, tom, americanCT),
        new Pizza ("Deluxe", deep, tom, deluxT),
        new Pizza ("Vegetarian", thin, sdt, vegT),
        new Pizza ("Meat Deluxe", deep, bbq, mdeluxT)
    };

    public void addAllTopingsToList(List<Toping> l, Toping[] t) {

        for (int i = 0; i < t.length; i++)
            l.add(t[i]);
    }
}
