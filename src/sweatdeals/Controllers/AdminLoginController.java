/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sweatdeals.Admin;
import static sweatdeals.Controllers.AdminController.admin;
import sweatdeals.DataBase.Authenticate;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class AdminLoginController implements Initializable {
     Authenticate authenthicate = new Authenticate();
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    Admin admin;
    @FXML
    private Label errorText;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     @FXML
    public void Authenticate(ActionEvent event){
            
            
            String UserInputUserName=username.getText();
            String UserInputPassword=password.getText();
            
            
            
            admin=authenthicate.isLoginAdmin(UserInputUserName, UserInputPassword);
            
            if( admin!=null ){
                errorText.setVisible(false);
                
                switchScene("Admin.fxml",event);
                
                 
            }
            else{
                errorText.setVisible(true);
            }
    
            
       
        
        
    }
    @FXML
    public void logout(ActionEvent event){
    switchScene("Home.fxml",event);
    } 
    
    public void  switchScene(String last,ActionEvent event){
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage= new Stage();
            FXMLLoader loader = new FXMLLoader();
            AdminController adminC= new AdminController();
            adminC.admin=admin;
            Parent root =loader.load(getClass().getResource(last));
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
}
