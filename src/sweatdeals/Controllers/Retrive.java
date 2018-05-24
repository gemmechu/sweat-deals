/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.Controllers;

import java.sql.*;
import java.util.ArrayList;
import sweatdeals.DataBase.DataBaseConnection;
import sweatdeals.Item;


/**
 *
 * @author ThinkPad
 */
public class Retrive {
    Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    PreparedStatement preparedStatement;
    
    ArrayList<Item> listOfItem =new ArrayList<>();
    public Retrive(){
    connection = DataBaseConnection.getConnection();
     if(connection==null){
     System.exit(1);
     }}
    public ArrayList<Item> retriveByUserName(String username){
try{
    String query = "SELECT * FROM item WHERE buyerUserName=?";
    preparedStatement =connection.prepareStatement(query);
   preparedStatement.setString(1,username);
    resultSet=preparedStatement.executeQuery();
    int j=0;
    while(resultSet.next()){
            Item item = new Item();
            item.setName(resultSet.getString("name"));
            item.setCatagory(resultSet.getString("catagory"));
            item.setId(resultSet.getInt("id"));
            item.setAmount(resultSet.getInt("amount"));
            listOfItem.add(item);
            
      }
     return listOfItem;     
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
             ex.printStackTrace();
         }
     }
     return listOfItem;
    }
    public void remove(String seller){
    
    
    try{
    String query = "Delete FROM seller WHERE userName=?";
    preparedStatement =connection.prepareStatement(query);
    preparedStatement.setString(1,seller);
    preparedStatement.executeUpdate();
//    String query = "delete from ex1 where id ='12'";
//    st.executeUpdate(query);
    }
     
     catch (Exception ex) {
             ex.printStackTrace();
         }
     }
     
    
    
    
     public ArrayList<Item> retrive(String catagory){
try{
    String query = "SELECT * FROM item WHERE sellerUserName=?";
    preparedStatement =connection.prepareStatement(query);
   preparedStatement.setString(1,catagory);
    resultSet=preparedStatement.executeQuery();
    int j=0;
    while(resultSet.next()){
            Item item = new Item();
            item.setName(resultSet.getString("name"));
            item.setCatagory(resultSet.getString("catagory"));
            listOfItem.add(j,item);
            j+=1;
            
      }
     return listOfItem;     
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
             ex.printStackTrace();
         }
     }
     return listOfItem;
    }
      public ArrayList<Item> retriveBogusProduct(){
try{
    String query = "SELECT * FROM item WHERE bogus=1";
    preparedStatement =connection.prepareStatement(query);
    resultSet=preparedStatement.executeQuery();
    int j=0;
    while(resultSet.next()){
            Item item = new Item();
            item.setName(resultSet.getString("name"));
            item.setCatagory(resultSet.getString("catagory"));
            item.setSellerName(resultSet.getString("sellerUserName"));
            item.setAmount(resultSet.getDouble("amount"));
            item.setId(resultSet.getInt("id"));
            item.setBuyerName(resultSet.getString("buyerUserName"));
            listOfItem.add(j,item);
            j+=1;
            
      }
     return listOfItem;     
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
             ex.printStackTrace();
         }
     }
     return listOfItem;
    }
    
    public ArrayList<Item> retriveAll(){
    ArrayList<Item> listOfItem1 = new ArrayList<>();
try{
    String query = "SELECT * FROM item";
    preparedStatement =connection.prepareStatement(query);
   
    resultSet=preparedStatement.executeQuery();
    int j=0;
    
    while(resultSet.next()){
            Item item = new Item();
            item.setName(resultSet.getString("name"));
            item.setCatagory(resultSet.getString("catagory"));
            item.setId(resultSet.getInt("id"));
            item.setAmount(resultSet.getDouble("amount"));
            
            listOfItem1.add(item);
            
            
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
             ex.printStackTrace();
         }
     }
     return listOfItem1;
    }
    public Item retriveItemById(int id){
    //ArrayList<Item> listOfItem1 = new ArrayList<>();
    Item item = new Item();
try{
    String query = "SELECT * FROM item where id=?";
    preparedStatement =connection.prepareStatement(query);
   preparedStatement.setInt(1, id);
    resultSet=preparedStatement.executeQuery();
     
    if(resultSet.next()){
            item.setName(resultSet.getString("name"));
            item.setCatagory(resultSet.getString("catagory"));
            item.setSellerName(resultSet.getString("sellerUserName"));
            item.setAmount(resultSet.getDouble("amount"));
            item.setId(resultSet.getInt("id"));
            item.setBuyerName(resultSet.getString("buyerUserName"));
            
          return item;  
            
            
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
             ex.printStackTrace();
         }
     }
     return item;
    }
    
}
