/**
 * 24/February/2010 Queries Completed.
 * 17/February/2010 Class Created.
 */

package control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import employees.*;
import entity.*;
import orders.*;
import products.*;

/**
 * @author Luke GJ Potter
 *
 */

public class Queries {

    //Declare Variables
    EntityManagerFactory emf;
    EntityManager em;
	
    //Default Constructor
    public Queries () {}

    //Instantiate the Entity Manager and Factory
    private void instantiateEntityManager() {
    	
    	emf = Persistence.createEntityManagerFactory("Pizza Shop");
    	em = emf.createEntityManager();
    }
    
    //Close the Entity Manager and Factory
    private void closeEntityManager() {
    	
    	em.close();
    	emf.close();
    }

    //Create new Shop Employee
    public ShopEmployee createNewShopEmployee (String first, String last, double rate, String pass) {

    	instantiateEntityManager();

    	ShopEmployee result = new ShopEmployee (first, last, rate, pass);

    	em.getTransaction().begin();
    	em.persist(result);
    	em.getTransaction().commit();

        closeEntityManager();

        return result;
    }

    //Create new Delivery Employee
    public DeliveryEmployee createNewDeliveryEmployee (String first, String last, double rate, String regNo, int fuelcardno) {

    	instantiateEntityManager();

    	DeliveryEmployee result = new DeliveryEmployee (first, last, rate, regNo, fuelcardno);

    	em.getTransaction().begin();
    	em.persist(result);
    	em.getTransaction().commit();

        closeEntityManager();

        return result;
    }

    //Shop Employee Login
    public ShopEmployee employeeLogin (String name, String password) {

        ShopEmployee emp = new ShopEmployee();

        try {

            instantiateEntityManager();

    	Query q = em.createQuery("SELECT s FROM ShopEmployee s WHERE s.employeeName = :n AND s.loginPassword = :password");
        q.setParameter("n", name);
        q.setParameter("password", password);
        emp = (ShopEmployee) q.getSingleResult();
    	
        } catch (NoResultException e) {

            emp = null;

        } finally {

            closeEntityManager();
            return emp;
        }
    }

    //Search for Customer
    public Customer searchForCustomer (String phoneNo) {
    
        Customer result = new Customer();
        
        try{

            instantiateEntityManager();

            Query q = em.createQuery("SELECT c FROM Customer c WHERE c.number = :phone");
            q.setParameter("phone", phoneNo);
            result = (Customer) q.getSingleResult();

        }catch (NoResultException e) {

            result = null;

        }finally {

            closeEntityManager();
            return result;
        }
    }

    //Create new Customer
    public Customer createNewCustomer (String num, String first, String last, String street, String city) {

    	instantiateEntityManager();
    	
    	Customer result = new Customer (num, first, last, street, city);
    	
    	em.getTransaction().begin();
    	em.persist(result);
    	em.getTransaction().commit();
    	
        closeEntityManager();
        
        return result;
    }

    //Edit Customer
    public Customer editCustomerAddress (String num, String street, String city) {

    	instantiateEntityManager();
        em.getTransaction().begin();

        String address = street + ", " + city;
    	
    	Query q = em.createQuery("UPDATE Customer c SET c.address = :add WHERE c.number = :number");
        q.setParameter("add", address);
        q.setParameter("number", num);
        q.executeUpdate();

        em.getTransaction().commit();
    	closeEntityManager();
        
        return searchForCustomer(num);
    }
    
    //Get all Drinks
    public List <Drink> returnAllDrinks () {

        List <Drink> list = new ArrayList <Drink> ();

        try {
    	instantiateEntityManager();
    	
    	Query q = em.createQuery("SELECT d FROM Drink d");
    	list = q.getResultList();
    	
        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }

    //Get all Deserts
    public List <Desert> returnAllDeserts () {

        List <Desert> list = new ArrayList <Desert> ();

        try {

            instantiateEntityManager();

            Query q = em.createQuery("SELECT d FROM Desert d");
            list = q.getResultList();

        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }

    //Get all Side Orders
    public List <SideOrder> returnAllSideOrders () {

        List <SideOrder> list = new ArrayList <SideOrder> ();

        try {

            instantiateEntityManager();

            Query q = em.createQuery("SELECT so FROM SideOrder so");
            list = q.getResultList();

        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }

    //Get all Pizzas
    public List <Pizza> returnAllPizzas () {

        List <Pizza> list = new ArrayList <Pizza> ();

        try {
    	instantiateEntityManager();
    	
    	Query q = em.createQuery("SELECT p FROM Pizza p");
    	list = q.getResultList();
    	
        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }
    
    //Get all Base Styles
    public List <BaseStyle> returnAllBaseStyles () {

        List <BaseStyle> list = new ArrayList <BaseStyle> ();

        try {
    	instantiateEntityManager();
    	
    	Query q = em.createQuery("SELECT bs FROM BaseStyle bs");
    	list = q.getResultList();
    	
        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }
    
    //Get all Sauces
    public List <Sauce> returnAllSauces () {

        List <Sauce> list = new ArrayList <Sauce> ();

        try {
    	instantiateEntityManager();
    	
    	Query q = em.createQuery("SELECT s FROM Sauce s");
    	list = q.getResultList();
    	
        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }
    
    //Get all Topings
    public List <Toping> returnAllTopings () {

        List <Toping> list = new ArrayList <Toping> ();

        try {
    	instantiateEntityManager();
    	
    	Query q = em.createQuery("SELECT t FROM Toping t");
        list = new ArrayList <Toping> ();
        list = q.getResultList();
        
        } catch (NoResultException e) {

            list = null;

        } finally {

            closeEntityManager();
            return list;
        }
    }

    //A Query to add a Side Order to the Menu
    public void persistSideOrder (String name, String desc, double p) {

        instantiateEntityManager();
        em.getTransaction().begin();
        em.persist(new SideOrder (name, desc, p));
        em.getTransaction().commit();
        closeEntityManager();
    }

    //A Query to add a Drink to the Menu
    public void persistDrink (String name, String desc, double size, double p) {

        instantiateEntityManager();
        em.getTransaction().begin();
        em.persist(new Drink (name, desc, size, p));
        em.getTransaction().commit();
        closeEntityManager();
    }

    //A Query to add a Desert to the Menu
    public void persistDesert (String name, String desc, double size, double p) {

        instantiateEntityManager();
        em.getTransaction().begin();
        new Desert (name, desc, size, p);
        em.getTransaction().commit();
        closeEntityManager();
    }

    //A Query to add a Base Style to the Menu
    public void persistBaseStyle (String name, String desc) {

        instantiateEntityManager();
        em.getTransaction().begin();
        em.persist(new BaseStyle (name, desc));
        em.getTransaction().commit();
        closeEntityManager();
    }

    //A Query to add a Sauce to the Menu
    public void persistSauce (String name) {

        instantiateEntityManager();
        em.getTransaction().begin();
        em.persist(new Sauce (name));
        em.getTransaction().commit();
        closeEntityManager();
    }

    //A Query to add a Toping to the Menu
    public void persistToping (String name) {

        instantiateEntityManager();
        em.getTransaction().begin();
        em.persist(new Toping (name));
        em.getTransaction().commit();
        closeEntityManager();
    }

    //A Query to add a Pizza to the Menu
    public void persistPizza (String name, BaseStyle base, Sauce sauce, List <Toping> topings) {

        instantiateEntityManager();
        em.getTransaction().begin();
        em.persist(new Pizza (name, base, sauce, topings));
        em.getTransaction().commit();
        closeEntityManager();
    }

    //Create new Custom Pizza
    public OrderLine createCustomPizza (int s, BaseStyle bs, Sauce sau, List <Toping> t) {

        int number = 0;
        Pizza customPizza = new Pizza (s, bs, sau, t);

        //ToDo get number from GUI
        OrderLine ol = new OrderLine (number, customPizza);
        return ol;
    }
}
