/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Loyalty.domain.Coupon;
import Loyalty.domain.Customer;
import Loyalty.domain.Transaction;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ryan Campion 2343075
 */
public class CustomerDAO {
    
    
    
    
    
    private static Map<String, Customer> customers = null;
    
    
    
    
    // create some dummy customers for testing purposes
	public CustomerDAO() {
		if (customers == null) {
			customers = new HashMap<>();			
                        
                        
                        
                        
                        
                        //Basic customers for testing
                        Customer cus1 = new Customer("0001", "m" , "10/11/1982");
                        cus1.addTransaction("1001", new Transaction("1001", 40));
                        cus1.addTransaction("1004", new Transaction("1004", 450));                        
                        cus1.createCoupon(2001, new Coupon(2001,23));
                        cus1.createCoupon(2005, new Coupon(2005,300));
                        
                        
                        Customer cus2 = new Customer("0002", "f" , "12/12/1971");
                        cus2.addTransaction("1002", new Transaction("1002", 100));
                        cus2.createCoupon(2003, new Coupon(2003,78));
                        
                        
                        Customer cus3 = new Customer("0003", "m", "14/08/1966");
                        cus3.addTransaction("1003", new Transaction("1003", 2000));
                        cus3.createCoupon(2004, new Coupon(2004,1500));
                        
                        
                        
                     
                        //Vend Customers
                        Customer cus4 = new Customer("bc305bf5-da76-11e4-f3a2-b723349226ba", "M", "1984-07-21");
                        cus4.addTransaction("1045", new Transaction("1045", 104));
                        
                        Customer cus5 = new Customer("b8ca3a6e-7276-11e4-fd8a-ea40bd311ca7", "F", "1985-03-03");
                        cus5.addTransaction("1345", new Transaction("1345", 34));
                        
                        
                        
                        
                        customers.put("0001", cus1);
                        customers.put("0002", cus2);
                        customers.put("0002", cus3);
                        customers.put("bc305bf5-da76-11e4-f3a2-b723349226ba", cus4);
                        customers.put("b8ca3a6e-7276-11e4-fd8a-ea40bd311ca7", cus5);
		}
	}
        
        
        
        
        public Collection<Customer> getAll(){
            return customers.values();            
        }
        
        
         public Customer getByID(String id) {
		return customers.get(id);
	}
        
         
          public Boolean exists(String id) {
		return customers.containsKey(id);
	}
          
          
         public void create(Customer customer) {
		customers.put(customer.getId(), customer);
	}
        
         
         public void delete(Customer customer) {
		customers.remove(customer.getId());
	}
         
         
         public void updateCustomer(String id, Customer customer) {
		customers.put(id, customer);
	}
           
}
