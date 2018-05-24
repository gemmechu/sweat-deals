/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sweatdeals.DataBase.Authenticate;
import sweatdeals.*;
import sweatdeals.DataBase.Buy;
import sweatdeals.DataBase.Insert;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class BuyerController implements Initializable {

    /**
     * Initializes the controller class.
     */
  @FXML
   private ListView listView;
  @FXML
   private Label usernameLabel;
   static Buyer buyer;
    ArrayList<Item> arrayListItem ;
   ObservableList<String> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usernameLabel.setText(buyer.getUsername());
        updateView();
    }    
    private void updateView() {
    Retrive retrive = new Retrive();
    arrayListItem =retrive.retriveAll();
    
    list= FXCollections.observableArrayList();
    
    int j=1;
    for(Item i : arrayListItem){
        
        String last = Integer.toString(j)+". Title      "+i.getName()+"\n"+"Catagory:   "+i.getCatagory()+"\n"+"ID: "+Integer.toString(i.getId());
        list.add(last);
        j+=1;
    }
    listView.setItems(list);
        
    }
       
    @FXML
    public void logout(ActionEvent event){
    switchScene("Home.fxml",event);
    }  
    @FXML
    public void feedBack(ActionEvent event){
    FeedBackController feed = new FeedBackController();
    feed.username=usernameLabel.getText();
    switchScene("FeedBack.fxml",event);
    
    } 
    @FXML
    public void buy(ActionEvent event){
     Buy buy = new Buy();
     Item item =new Item();
     ObservableList<String> name = listView.getSelectionModel().getSelectedItems();
     Retrive retrive= new Retrive();
     item.setId(Integer.parseInt(name.get(0).substring(name.get(0).length()-2, name.get(0).length())));
     Item item2= retrive.retriveItemById(item.getId());
     System.out.println("item2"+item2.getName());
     BuyController buyers= new BuyController();
     buyers.amountM=Double.toString(item2.getAmount());
     buyers.sellerNameM=item2.getSellerName();
     buyers.itemId=item2.getId();
     buyers.catagoryM=item2.getCatagory();
     buyers.userName=usernameLabel.getText();
     switchScene("Buy.fxml",event);
     
    
    }
    public void  switchScene(String last,ActionEvent event){
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage= new Stage();
            Parent root =FXMLLoader.load(getClass().getResource(last));
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println("as");
        }
    
    }
}

