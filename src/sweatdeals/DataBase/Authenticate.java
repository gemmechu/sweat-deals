/*
 * To change this license header, choose License HeaderesultSet in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sweatdeals.*;

/**
 *
 * @author ThinkPad
 */
public class Authenticate {
    public ArrayList<Object> data;
    Connection connection;
     Seller seller ;
     Buyer buyer;
     Admin admin;
     public Authenticate(){
     connection = DataBaseConnection.getConnection();
     if(connection==null){
     System.exit(1);
     }
     }
     public boolean isDBconnected( ){
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            return false;
          
        }
     
     }
     public Seller isLogin(String user, String pass,String table){
     
     PreparedStatement preparedStatement = null;
     ResultSet resultSet = null;
     String query1="select * from";
     String query = query1.concat(table).concat("where userName=?  and password =? ");
         System.out.println("query: "+query);
     try{
     preparedStatement = connection.prepareStatement(query);
     
     preparedStatement.setString(1, user);
     
     preparedStatement.setString(2, pass);
     
     resultSet = preparedStatement.executeQuery();
     
     
     if(resultSet.next()){
         System.out.println("if");
         
          String name = resultSet.getString("userName");
           String password = resultSet.getString("password");
           //ArrayList<Item> item = resultSet.getString("address");
           
           seller = new Seller(name, password);
           
     return seller;
     }
     else{
     System.out.println("ELSE");
     return null;
         
     }
     }
     catch(Exception e){
         System.out.println("CATCH");
     return null;  
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

public Admin isLoginAdmin(String user, String pass){
     
     PreparedStatement preparedStatement = null;
     ResultSet resultSet = null;
     
     String query = "select * from admin where userName=?  and password =? ";
         
     try{
     preparedStatement = connection.prepareStatement(query);
     
     preparedStatement.setString(1, user);
     
     preparedStatement.setString(2, pass);
     
     resultSet = preparedStatement.executeQuery();
     
     
     if(resultSet.next()){
         System.out.println("if");
         
          String name = resultSet.getString("userName");
           String password = resultSet.getString("password");
           //ArrayList<Item> item = resultSet.getString("address");
           
           admin = new Admin(name, password);
           
     return admin;
     }
     else{
     System.out.println("ELSE");
     return null;
         
     }
     }
     catch(Exception e){
         System.out.println("CATCH");
     return null;  
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
public Buyer isBLogin(String user, String pass,String table){
         
     
     PreparedStatement preparedStatement = null;
     ResultSet resultSet = null;
     String query1="select * from";
         System.out.println("okk it have ");
     String query = query1.concat(table).concat("where userName=?  and password =? ");
         System.out.println("query: "+query);
     try{
     preparedStatement = connection.prepareStatement(query);
     
     preparedStatement.setString(1, user);
         System.out.println("user"+user);
     
     preparedStatement.setString(2, pass);
     
     resultSet = preparedStatement.executeQuery();
     
     
     if(resultSet.next()){
         System.out.println("if");
         
          String name = resultSet.getString("userName");
           String password = resultSet.getString("password");
           //ArrayList<Item> item = resultSet.getString("address");
           
           buyer = new Buyer(name, password);
           
     return buyer;
     }
     else{
     System.out.println("ELSE");
     return null;
         
     }
     }
     catch(Exception e){
         System.out.println("CATCH");
     return null;  
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
     
     public Seller getFiles(){
         return seller;
     }
}
