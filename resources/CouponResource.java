/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import dao.CustomerDAO;
import Loyalty.domain.Coupon;
import Loyalty.domain.Customer;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ryan Campion 2343075
 */
@Path("/customers/{customer-id}/coupons/{couponID}")
public class CouponResource {
    
    
    Customer customer;
    Coupon coupon;
    CustomerDAO dao = new CustomerDAO();

 
    //Contructor
    public CouponResource(@PathParam("customer-id") String customerId, 
                            @PathParam("couponID") String couponID){
        //get the customer
        customer = dao.getByID(customerId);
        
        //get coupon
        Integer couponIdInteger = Integer.parseInt(couponID);
        if(customer.couponExists(couponIdInteger)){
            coupon = customer.getCoupon(couponIdInteger);
        } else{
           throw new NotFoundException("There is no transaction that matches that ID");
        }
     
    }
    
    
    
    @GET
    public Coupon getCoupon(){
        return coupon;
    }
    
    
    
    
    
    @PUT
    public Response updateCoupon(Coupon updatedCoupon) {
        if(coupon.getId().equals(updatedCoupon.getId())) {
            coupon.setUsed(true);
     return Response.noContent().build();
   } else {
     return Response
            .status(Response.Status.CONFLICT)
            .entity("Coupon IDs don't match")
            .build();
    }
    }
    
}
