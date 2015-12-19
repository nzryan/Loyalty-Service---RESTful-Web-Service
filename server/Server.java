/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import filters.CorsFilter;
import filters.DebugFilter;
import filters.ExceptionHandler;
import java.net.URI;
import java.net.URISyntaxException;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;
import resources.CouponResource;
import resources.Coupons;
import resources.CustomerResource;
import resources.Points;
import resources.TransactionResource;
import resources.Transactions;

/**
 *
 * @author Ryan Campion 2343075
 */
public class Server {
    
    public static void main (String[] args) throws Exception{
        
       
     // configure the unified logger
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        // create a web service configuration
        ResourceConfig config = new ResourceConfig();

        // add a debug filter that prints request details
        config.register(DebugFilter.class);
        config.register(ExceptionHandler.class);
        
         // add the CORS filter to allow AJAX clients to access the service
       config.register(CorsFilter.class);
       
       // add our resource classes
        config.register(CouponResource.class);
        config.register(Coupons.class);
        config.register(Points.class);
        config.register(TransactionResource.class);
        config.register(Transactions.class);
        config.register(CustomerResource.class);

        // define the URI that the server will use
        URI baseUri = new URI("http://localhost:8081/");

        // start the server (via the built-in Java HTTP server)
        JdkHttpServerFactory.createHttpServer(baseUri, config);

        System.out.println("Hello Ryan your REST Service Ready on http://localhost:8081/");

        
        
    }
    
}
