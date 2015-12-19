/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;


import dao.CustomerDAO;
import Loyalty.domain.Customer;
import Loyalty.domain.Transaction;
import java.net.URI;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ryan Campion 2343075
 */

@Path("/customers/{cutomer-id}/transactions")
public class Transactions {

    
    
    

    Customer customer;
    CustomerDAO dao = new CustomerDAO();
    
    
    
    
    

    public Transactions(@PathParam("cutomer-id") String customerId) {
        
        //get the customer
        customer = dao.getByID(customerId);
        
        
          if (dao.exists(customerId)){
            customer = dao.getByID(customerId);
        }else{
            customer = new Customer(customerId);
            dao.create(customer);
        }
        
    }
    

    
    
    
    
    
    
    

    
    
    
    @GET
    public Collection<Transaction> getTransactions(){
        return customer.getTransactions().values();
    }
    
    
    
    
//    @POST
//    public Response createTransaction(Transaction transaction, @Context UriInfo uri){       
//        customer.addTransaction(transaction.getId(), transaction);       
//          URI newURI = uri.getAbsolutePathBuilder().path(transaction.getId()).build();
//           return Response.created(newURI).build();
//    }
    
    
    
    @POST
    public void createTransaction(Transaction transaction){       
        customer.addTransaction(transaction.getId(), transaction);  
    }
    
}
