/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

import java.util.ArrayList;

/**
 *
 * @author harshalneelkamal
 */
public class Customer {
    
    int customerId;
    ArrayList<Order> orders;   

    public Customer(int customerId) {
        this.customerId = customerId;
        this.orders=new ArrayList<>();
    }

    public int getCustId() {
        return customerId;
    }

    public void setCustId(int custId) {
        this.customerId = customerId;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{"+ customerId+"}";
    }
    
}
