/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sweatdeals.Item;

/**
 *
 * @author ThinkPad
 */
public class Buy {
    Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    PreparedStatement preparedStatement;
    Item item = new Item();
    ArrayList<Item> listOfItem =new ArrayList<>();
    public Buy(){
    connection = DataBaseConnection.getConnection();
     if(connection==null){
     System.exit(1);
     }}
    public void buy(Item item){
try{
    
    String q1=item.getBuyerName();
    int id=item.getId();
    String query1="UPDATE item  Set buyerUserName=? ,status=1 Where id= ".concat(Integer.toString(id));

    preparedStatement =connection.prepareStatement(query1);
    preparedStatement.setString(1, q1);
    preparedStatement.executeUpdate();
}
     catch(Exception e){
         e.printStackTrace();
   }
     finally{
      try {
            preparedStatement.close();
                 
         } 
     
     catch (Exception ex) {
             ex.printStackTrace();
         }
     }
     
    }
    public void markAsBogus(Item item){
try{
    
    String q1=item.getBuyerName();
    int id=item.getId();
    String query1="UPDATE item  Set bogus=1 Where id= ".concat(Integer.toString(id));

    preparedStatement =connection.prepareStatement(query1);
    
    preparedStatement.executeUpdate();
}
     catch(Exception e){
         e.printStackTrace();
   }
     finally{
      try {
            preparedStatement.close();
                 
         } 
     
     catch (Exception ex) {
             ex.printStackTrace();
         }
     }
     
    }
}
