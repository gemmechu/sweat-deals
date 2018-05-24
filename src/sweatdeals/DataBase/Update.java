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
import java.util.ArrayList;
import sweatdeals.Item;


public class Update {
    Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    PreparedStatement preparedStatement;
    public Update(){
    connection = DataBaseConnection.getConnection();
     if(connection==null){
     System.exit(1);
     }}
    public void insert(){
   
    
     try{
    String query = "SELECT * FROM item";
    
    
    preparedStatement =connection.prepareStatement(query);

   resultSet=preparedStatement.executeQuery();

      while(resultSet.next()){
                System.out.println("hh  "+resultSet.getString("name"));
      }
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
