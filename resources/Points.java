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
@Path("/customers/{customer-id}/points") 
public class Points {
    
    
    
    
    Customer customer;
    CustomerDAO dao = new CustomerDAO();
    
    
    
    public Points (@PathParam("customer-id") String customerId){
          //get the customer
        customer = dao.getByID(customerId);
    }
    
    
    
    
    
    @GET @Path("/total")  
  public Integer getTotal() { 
      return customer.getTotalPoints();
  }
  
  
  
  
   @GET @Path("/unused")  
  public Integer getUnused() { 
      return customer.getUnusedPoints();
  }
    
    
    
    
}
