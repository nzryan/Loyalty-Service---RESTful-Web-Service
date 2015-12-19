package resources;

import dao.CustomerDAO;
import Loyalty.domain.Customer;
import Loyalty.domain.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ryan Campion 2343075
 */

@Path("/customers/{customer-id}/transactions/{transactionID}")
public class TransactionResource {
    
    Customer customer;
    Transaction transaction;
    CustomerDAO dao = new CustomerDAO();

 
    //Contructor
    public TransactionResource(@PathParam("customer-id") String customerId, 
                               @PathParam("transactionID") String transactionId){
        //get the customer
        customer = dao.getByID(customerId);
        
        //get transaction
        if(customer.transactionExists(transactionId)){
            transaction = customer.getTransaction(transactionId);
        } else{
           throw new NotFoundException("There is no transaction that matches that ID");
        }
     
    }
    
    
    
    
    //a method named getTransaction that returns the transaction field.
    @GET
    public Transaction getTransaction(){
        return transaction;
    }
  
    
    
    
}
