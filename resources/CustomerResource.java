package resources;

import dao.CustomerDAO;
import Loyalty.domain.Customer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Ryan Campion 2343075
 */
@Path("/customers/{customer-id}")
public class CustomerResource {
    
     CustomerDAO dao = new CustomerDAO();
         Customer customer;

         
         
         
         
          //Contructor
    public CustomerResource(@PathParam("customer-id") String customerId){
        //get the customer
        customer = dao.getByID(customerId);

    }
    
    
    
    
     @GET
    public Customer getCustomer(){
        return customer;
    }
    
}
