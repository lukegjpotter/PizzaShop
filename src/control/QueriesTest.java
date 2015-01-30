/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

//import javax.persistence.*;
import employees.ShopEmployee;
import entity.Customer;
import java.util.List;
import products.*;

/**
 * @author Luke GJ Potter
 *
 */

public class QueriesTest {

    public static void main (String[] args) {

        //Declare Variables
        Queries q = new Queries();
        
        //Test Shop Employee Login
        ShopEmployee emp = q.employeeLogin("Peter Jenkins", "password1");
        System.out.println(emp.toString());
    
//        //Test Search for Customer
//        Customer c = q.searchForCustomer("0851234567");
//        System.out.println(c.toString());
//
//        //Test Edit Customer
//        Customer c2 = q.editCustomerAddress("0851234567", "Dominick St.", "Galway");
//        System.out.println(c2.toString());
//
//        //Test Return All Drinks
//        List <Drink> drink = q.returnAllDrinks();
//        System.out.println(drink.toString());
//
//        //Test Return All Deserts
//        List <Desert> desert = q.returnAllDeserts();
//        System.out.println(desert.toString());
//
//        //Test Return All Side Orders
//        List <SideOrder> sideorder = q.returnAllSideOrders();
//        System.out.println(sideorder.toString());
//
//        //Test Return All Base Styles
//        List <BaseStyle> basestyle = q.returnAllBaseStyles();
//        System.out.println(basestyle.toString());
//
//        //Test Return All Sauces
//        List <Sauce> sauce = q.returnAllSauces();
//        System.out.println(sauce.toString());
//        //Test Return All Topings
//
//        List <Toping> toping = q.returnAllTopings();
//        System.out.println(toping.toString());
//
//        //Test Return All Pizzas
//        List <Pizza> pizza = q.returnAllPizzas();
//        System.out.println(pizza.toString());
    }
}
