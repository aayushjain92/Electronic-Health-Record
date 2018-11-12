/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.analysis;

import assignment_4.entities.Customer;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author global
 */
public class AnalysisHelp {
    
    public List<Product> top3MostPopularProducts(){
        Map<Integer, Product> products=DataStock.getInstance().getProducts();
        List<Product> list=new ArrayList<>(products.values());
        Collections.sort(list, new Comparator<Product>(){
           
            @Override
            public int compare(Product o1, Product o2) {
            
                int qty1=0;
                for(Order o:o1.getOrders()){
                    qty1+=o.getItem().getQuantity();
                }
                int qty2=0;
                for(Order o:o2.getOrders()){
                    qty2+=o.getItem().getQuantity();
                }
                return qty2-qty1;
            }          
        });
        
        return list;
    }
    
    public List<Customer> top3BestCustomers(){
        Map<Integer,Customer> customers=DataStock.getInstance().getCustomers();
        List<Customer> list=new ArrayList<>(customers.values());
        Collections.sort(list, new Comparator<Customer>(){
            
            @Override
            public int compare(Customer o1, Customer o2) {
                int revenueOfCustomer1=0;
                for(Order o:o1.getOrders()){
                    revenueOfCustomer1+=(o.getItem().getSalesPrice())*(o.getItem().getQuantity());
                }
                int revenueOfCustomer2=0;
                for(Order o:o2.getOrders()){
                    revenueOfCustomer2+=(o.getItem().getSalesPrice())*(o.getItem().getQuantity());
                }
                return revenueOfCustomer2-revenueOfCustomer1;
            }
            
        });
        return list;
    }
    
    public int totalRevenueGenerated(){
        Map<Integer, Order> orderListMap= DataStock.getInstance().getOrders();
        int totalRevenue=0;
        for(Map.Entry<Integer,Order> entry: orderListMap.entrySet()){
            Order o=entry.getValue();
            int salesPrice=o.getItem().getSalesPrice();
            int quantity=o.getItem().getQuantity();
            Product p=DataStock.getInstance().getProducts().get(o.getItem().getProductId());
            int minPrice=p.getMinPrice();
            totalRevenue+=(salesPrice-minPrice)*quantity;
        }
        return totalRevenue;
    }
    
}
