/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.CustomerDAO;
import Loyalty.domain.Coupon;
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

@Path("/customers/{cutomer-id}/coupons")
public class Coupons {
    
    
    
    
    
    Customer customer;
    CustomerDAO dao = new CustomerDAO();
    

    
    
    
    
    
    public Coupons(@PathParam("cutomer-id") String customerId) {
        
        //get the customer
        customer = dao.getByID(customerId);
    }
    
    
    
    
    
    
    
    
     @GET
    public Collection<Coupon> getCoupons(){
        return customer.getCoupons().values();
    }
    
    
    
    
    @POST
    public Response createCoupon(Coupon coupon, @Context UriInfo uri){       
        customer.createCoupon(coupon.getId(), coupon);   
        String couponIdString = Integer.toString(coupon.getId());
          URI newURI = uri.getAbsolutePathBuilder().path(couponIdString).build();
           return Response.created(newURI).build();
    }
}
