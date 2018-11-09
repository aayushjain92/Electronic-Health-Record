/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import java.util.Comparator;
import lab_8.entities.User;

/**
 *
 * @author global
 */
public class InactiveUserCommentComparator implements Comparator<User> {
    
        @Override
    public int compare(User u1, User u2)
    {
        if(u1.getComments().size()<u2.getComments().size())return -1;
        else if(u1.getComments().size()>u2.getComments().size())return 1;
        else
        return 0;
    }
    
}
