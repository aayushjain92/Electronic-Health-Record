/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import java.util.Comparator;
import lab_8.entities.Comment;


public class CommentLikeCompare implements Comparator<Comment>{
    @Override
    public int compare(Comment c1, Comment c2)
    {
        if(c1.getLikes()<c2.getLikes())return 1;
        else if(c1.getLikes()>c2.getLikes())return -1;
        else
        return 0;
    }
    
}
