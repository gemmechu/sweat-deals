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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DataBaseConnection {
   
public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SweatDeals","root","");
           return connection;
        }
        catch(Exception e){
            return null;
        }
    }
}
