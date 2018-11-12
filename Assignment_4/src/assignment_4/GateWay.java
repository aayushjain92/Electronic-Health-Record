/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment_4.analysis.AnalysisHelp;
import assignment_4.analysis.DataStock;
import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author harshalneelkamal
 */
public class GateWay {
    
     static AnalysisHelp analysisHelp;
    public GateWay() throws IOException{
       analysisHelp=new AnalysisHelp();
    }
    
    public static void main(String args[]) throws IOException{
        
        DataGenerator generator = DataGenerator.getInstance();
        GateWay gateway = new GateWay();
        
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
        DataReader orderReader = new DataReader(generator.getOrderFilePath());
        String[] orderRow;
        //printRow(orderReader.getFileHeader());
        while((orderRow = orderReader.getNextRow()) != null){
            produceOrders(orderRow);
        }
        //System.out.println("_____________________________________________________________");
        
        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        String[] prodRow;
        //printRow(productReader.getFileHeader());
        while((prodRow = productReader.getNextRow()) != null){
            produceProducts(prodRow);
        }
        
        List<Product> listProduct=analysisHelp.top3MostPopularProducts();
        System.out.println("\n ----------Top 3 Popular Products--------- ");
        for(int i=0;i<3;i++){
            System.out.print(listProduct.get(i)+"\t");          
        }
        System.out.println();
        List<Customer> listCustomer=analysisHelp.top3BestCustomers();
        System.out.println("\n----------- Top 3 Best Customers----------- ");
        for(int i=0;i<3;i++){
            System.out.print(listCustomer.get(i)+"\t");           
        }
       
         System.out.println();
         System.out.println("\n----------------------------------------- ");
         System.out.println("Total Revenue generated for the year: " +analysisHelp.totalRevenueGenerated());
         System.out.println("----------------------------------------- ");
    }
    
       public static void produceProducts(String[] row){
        int productId=Integer.parseInt(row[0]);
        int min=Integer.parseInt(row[1]);
        int max=Integer.parseInt(row[2]);
        int target=Integer.parseInt(row[3]);
        Product x=new Product(productId,min,max,target);
        DataStock.getInstance().getProducts().put(productId, x);
    }
    
    public static void produceOrders(String[] row){
        int orderId=Integer.parseInt(row[0]);
        int itemId=Integer.parseInt(row[1]);
        int productId=Integer.parseInt(row[2]);
        int quantity=Integer.parseInt(row[3]);
        int salesId=Integer.parseInt(row[4]);
        int customerId=Integer.parseInt(row[5]);
        int salesPrice=Integer.parseInt(row[6]);
        Map<Integer, Product> products= DataStock.getInstance().getProducts();
        
        Item i= new Item(productId, salesPrice, quantity);
        Order o=new Order(orderId, salesId, customerId, i);
        
        DataStock.getInstance().getOrders().put(orderId, o);
        if(products.containsKey(productId)){
            Product p=products.get(productId);
            ArrayList<Order> orderListPerProduct= p.getOrders();
            orderListPerProduct.add(o);
        }
        
        Map<Integer, Customer> customerMap=DataStock.getInstance().getCustomers();
        if(!customerMap.containsKey(customerId)){
            Customer c=new Customer(customerId);
            DataStock.getInstance().getCustomers().put(customerId, c);
            c.getOrders().add(o);
        }else{
           Customer c=customerMap.get(customerId);
           c.getOrders().add(o);
        }
      
        Map<Integer, SalesPerson> salesMap=DataStock.getInstance().getSalesPeople();
        if(!salesMap.containsKey(salesId)){
            SalesPerson s=new SalesPerson(salesId);
            DataStock.getInstance().getSalesPeople().put(salesId, s);
            s.getOrders().add(o);
        }else{
           SalesPerson s=salesMap.get(salesId);
           s.getOrders().add(o);
        }
        
    }
    
}
