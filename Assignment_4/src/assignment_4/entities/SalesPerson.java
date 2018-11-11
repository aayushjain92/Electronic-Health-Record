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
public class SalesPerson {
    
    int salesId;
    ArrayList<Order> orders;

    public SalesPerson(int salesId) {
        this.salesId = salesId;
        this.orders=new ArrayList<>();
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "SalesPerson{" + salesId + '}';
    }
    
    
}
