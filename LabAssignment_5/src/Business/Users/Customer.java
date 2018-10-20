
package Business.Users;

import Business.Abstract.User;
import java.util.Date;

public class Customer extends User implements Comparable<Customer>{
  private Date dateCreated;

    public Customer(Date dateCreated, String password, String userName) {
        super(password, userName, "Customer");
        this.dateCreated = dateCreated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    
    @Override
    public boolean verify(String password) {
        if(password.equals(getPassword()))
            return true;
        return false;
    }

    @Override
    public int compareTo(Customer o) {
        return getUserName().compareTo(o.getUserName());
    }
  
  

           
}
