/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_8.analytics;

import Comparators.CommentCountCompare;
import Comparators.InactiveUserCommentComparator;
import Comparators.InactiveUserPostComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lab_8.entities.Comment;
import lab_8.entities.Post;
import lab_8.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    
    public void averageNumberOfLikesPerComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
     Map<Integer, User> Users = DataStore.getInstance().getUsers();
       
        int likesSum = 0;
       
        for(Comment comment: comments.values()) {
            likesSum += comment.getLikes();
        }
        System.out.println("\n-----------Average Likes per Comment = "+ likesSum/comments.size()+"-----------");
    }
    public void userWithMostLikes(){
        Map<Integer , Integer> userLikecount = new HashMap<Integer , Integer>(); 
                 
                 
         Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        for(User user : users.values())
            
            for(Comment c : user.getComments())
            {
                
                
                int likes = 0 ;
                if(userLikecount.containsKey(user.getId()))
                    likes = userLikecount.get(user.getId());
                likes += c.getLikes();
                    userLikecount.put(user.getId(), likes);
                    
    }
        
        int max=0;
        int maxId=0;
        
        for(int id : userLikecount.keySet()){
        if(userLikecount.get(id) > max){
            
          
            max= userLikecount.get(id);
            maxId = id;
            
            
            
        }
        
    }
        System.out.println("\n------------User  with most likes  :"  +max+ "\n" +users.get(maxId)+"-------------");
    }
    
    public void postWithMostLikedComments()
    {
         Map<Integer, Integer> postLikeCount = new HashMap<Integer, Integer>();
          Map<Integer, Post> posts = DataStore.getInstance().getPosts();
          for(Post post : posts.values()) {
              for(Comment c : post.getComments()){
                  int likes = 0;
                  if(postLikeCount.containsKey(post.getPostId())){
                      likes = postLikeCount.get(post.getPostId());
                  }
              likes += c.getLikes();
              postLikeCount.put(post.getPostId(), likes);
              }
          }
          int max = 0;
          int maxId = 0;
          for(int id : postLikeCount.keySet()){
              if(postLikeCount.get(id) > max) {
                  max = postLikeCount.get(id);
                  maxId = id;
              }
          }
          System.out.println("\n------------Post with most Liked Comment is: "+ maxId + "\nTotal number of likes: "+max+"-----------");
    }
    
    
    
    public void getFiveMostLikedComment(){
         Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        
        List<Comment> commentList = new ArrayList<>(comments.values());
        
       Collections.sort(commentList, new Comparator<Comment>(){
       
       @Override
       
       public int compare(Comment o1, Comment o2){
       
           return o2.getLikes() -  o1.getLikes();
           
       }
       
       
       });
       
        System.out.println("\n--------------------5 most liked comments--------------------");
        
        for(int i = 0 ; i < commentList.size() && i < 5 ; i++){
        
            
            System.out.println(commentList.get(i));
        }
    
        
    }
    
    public void postWithMostComments()
    {
        Map<Integer, Post> posts=DataStore.getInstance().getPosts();
        CommentCountCompare commentCountCompare=new CommentCountCompare();
        List<Post> postList=new ArrayList<>(posts.values());
        Collections.sort(postList,commentCountCompare);
        System.out.println("\n--------------------Post With most Comments-----------------");
        System.out.println("Post ID : " + postList.get(0).getPostId());
               System.out.println( "Post Created By : " + postList.get(0).getPostId());
               System.out.println("Comment Count : "+postList.get(0).getComments().size());               
    }
    
    public void fiveMostInactiveUserPost()
    {
        
        Map<Integer, User> users=DataStore.getInstance().getUsers();
        InactiveUserPostComparator inactiveUserPostComparator=new InactiveUserPostComparator();
        List<User> userList=new ArrayList<>(users.values());
        Collections.sort(userList,inactiveUserPostComparator);
        System.out.println("\n--------------5 Most Inactive User By Post-------------------");
        int count=userList.size();
        if(count>=5)
            count=5;
        for(int i=0;i<count;i++)
        {
        System.out.println("First Name : " + userList.get(i).getFirstName());
                System.out.println("Last Name : " + userList.get(i).getLastName());
                
               System.out.println( "Post Count : " + userList.get(i).getPosts().size());
  
        }
    }
    
     public void fiveMostInactiveUserComment()
    {
        
        Map<Integer, User> users=DataStore.getInstance().getUsers();
        InactiveUserCommentComparator inactiveUserCommentComparator=new InactiveUserCommentComparator();
        List<User> userList=new ArrayList<>(users.values());
        Collections.sort(userList,inactiveUserCommentComparator);
        System.out.println("\n---------------5 Most Inactive User By Comments-------------------");
        int count=userList.size();
        if(count>=5)
            count=5;
        for(int i=0;i<count;i++)
        {
        System.out.println("First Name : " + userList.get(i).getFirstName());
                System.out.println("Last Name : " + userList.get(i).getLastName());
                
               System.out.println( "Comment Count : " + userList.get(i).getComments().size());
  
        }
    }
     
  public void inactiveUsersOnPostsLikeandComments(){
          Map<Integer, User> users = DataStore.getInstance().getUsers();
  System.out.println("\n-------------Inactive user based on posts,likes and comments----------------------------");
  List<User> userList = new ArrayList<>(users.values());
  Collections.sort(userList, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
            return (o1.getPosts().size()+ o1.getComments().size()) - ( o2.getPosts().size() + o2.getComments().size());
      }
  });
  for(int i = 0; i<5;i++){
      System.out.println(userList.get(i).getId());
  }
 }
      
      public void proactiveUsersOnPostsLikeandComments(){
           Map<Integer, User> users = DataStore.getInstance().getUsers();
  System.out.println("\n-------------Proactive user based on posts,likes and comments----------------------------");
  List<User> userList = new ArrayList<>(users.values());
  Collections.sort(userList, new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
          return (o1.getPosts().size()+ o1.getComments().size()) - ( o2.getPosts().size() + o2.getComments().size());    
      }
  });
  for(int i = 0; i<5;i++){
      System.out.println(userList.get(i).getId());
  }
 }
    
}
