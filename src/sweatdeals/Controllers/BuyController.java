/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sweatdeals.DataBase.Buy;
import sweatdeals.Item;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class BuyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label amount;
    @FXML
    private Label sellerName;
    @FXML
    private Label catagory;
     @FXML
    private Label usernameLabel;
      @FXML
    private Label successText;
      @FXML
    private Label home;
    public static String amountM;
    public static String sellerNameM;
    public  static String catagoryM;
    public  static String userName;
    public  static int itemId;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sellerName.setText(sellerNameM);
        amount.setText(amountM);
        catagory.setText(catagoryM);
        usernameLabel.setText(userName);
    }
@FXML
    public void gotoHome(ActionEvent event){
    switchScene("Buyer.fxml",event);
    }  
      public void Logout(ActionEvent event){
    switchScene("Home.fxml",event);
    }
 @FXML
    public void buy(ActionEvent event){
     Buy buy = new Buy();
     Retrive retrive= new Retrive();
     Item item =retrive.retriveItemById(itemId);
     item.setBuyerName(userName);
     buy.buy(item);
     successText.setVisible(true);
    
    }   
      public void  switchScene(String last,ActionEvent event){
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage= new Stage();
            FXMLLoader loader = new FXMLLoader();
            
            Parent root =loader.load(getClass().getResource(last));
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
}
