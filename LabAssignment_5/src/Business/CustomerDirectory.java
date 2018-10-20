
package Business;

import Business.Abstract.User;
import Business.Users.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDirectory {
    
    private List<User> customerList;
    
    public CustomerDirectory(){
        customerList = new ArrayList<>();
    }

    public List<User> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<User> supplierList) {
        this.customerList = supplierList;
    }
    
    public Customer addCustomer(Date dateCreated, String password, String userName)
    {
        Customer c = new Customer(dateCreated, password, userName);
        customerList.add(c);
        return c;
    }
    
    public void removeCustomer(Customer c)
    {
        customerList.remove(c);        
    }

}
