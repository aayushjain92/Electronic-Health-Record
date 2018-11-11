/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.analysis;

import assignment_4.entities.Customer;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author global
 */
public class DataStock {
    
    private static DataStock dataStock;
    
    private Map<Integer, Product> products;
    private Map<Integer, Customer> customers;
    private Map<Integer, SalesPerson> salesPeople;
    private Map<Integer, Order> orders;
    
    private DataStock(){
        products = new HashMap<>();
        customers = new HashMap<>();
        salesPeople = new HashMap<>();
        orders = new HashMap<>();
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    
    public static DataStock getInstance(){
        if(dataStock == null)
            dataStock = new DataStock();
        return dataStock;
    }

    public static DataStock getDataStock() {
        return dataStock;
    }

    public static void setDataStore(DataStock dataStock) {
        DataStock.dataStock = dataStock;
    }
    
    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Map<Integer, SalesPerson> getSalesPeople() {
        return salesPeople;
    }

    public void setSalesPeople(Map<Integer, SalesPerson> salesPeople) {
        this.salesPeople = salesPeople;
    }
    
}
