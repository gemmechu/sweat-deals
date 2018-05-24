/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sweatdeals.DataBase.Authenticate;
import sweatdeals.*;


/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField username;
    @FXML
    private TextField password;
   @FXML
    private Label errorText;
   Seller seller;
   Buyer buyer;
    @FXML
    private RadioButton CheckBuyer;
   Authenticate authenthicate = new Authenticate();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   @FXML
    public void Authenticate(ActionEvent event){
            
            
            String UserInputUserName=username.getText();
            String UserInputPassword=password.getText();
            if(!CheckBuyer.isSelected()){
            
            String table=" buyer ";
            seller=authenthicate.isLogin(UserInputUserName, UserInputPassword," seller ");
            
            if( seller!=null ){
                errorText.setVisible(false);
                
                switchScene("SellerAccount.fxml",event);
                
                 
            }
            else{
                errorText.setVisible(true);
            }
    
            }
            else{
                String table=" buyer ";
                buyer =authenthicate.isBLogin(UserInputUserName, UserInputPassword, table);
            
            
            if( buyer!=null ){
                errorText.setVisible(false);
                
                switchScene("Buyer.fxml",event);
                
                 
            }
            else{
                errorText.setVisible(true);
            }
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
            SellerAccountController sellerC= new SellerAccountController();
            BuyerController buyerC= new BuyerController();
            buyerC.buyer=buyer;
            sellerC.seller=seller;
            Parent root =loader.load(getClass().getResource(last));
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
}
