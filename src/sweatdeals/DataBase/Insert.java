/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.DataBase;

/**
 *
 * @author ThinkPad
 */
 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import sweatdeals.Item;

public class Insert {
    Connection connection;
    private Statement st;
    private ResultSet resultSet;
    PreparedStatement preparedStatement;
    public Insert(){
    connection = DataBaseConnection.getConnection();
     if(connection==null){
     System.exit(1);
     }}
    public void insert(Item item){
   
     String query = "INSERT INTO item (name,catagory,sellerUserName,amount) VALUES(?,?,?,?)";
     try{
     preparedStatement =connection.prepareStatement(query);
     
     preparedStatement.setString(1,item.getName());
     
     preparedStatement.setString(2, item.getCatagory());
     preparedStatement.setString(3, item.getSellerName());
     preparedStatement.setDouble(4, item.getAmount());
     preparedStatement.execute();
     
     }
     catch(Exception e){
         e.printStackTrace();
   }
     finally{
      try {
             preparedStatement.close();
               resultSet.close();       
         } 
     
     catch (Exception ex) {
             
         }
     }
     }
}
