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
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sweatdeals.Item;
import sweatdeals.Seller;
import sweatdeals.*;
import sweatdeals.DataBase.*;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class  SellerAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public  Label username;
    @FXML
    public  Button uploadButton;
    @FXML
    public  Button backButton;
    @FXML
    public  ListView listView;
    @FXML
    public  RadioButton catagory;
  
    @FXML
    public  AnchorPane viewPost;
    @FXML
    public  AnchorPane newUpload;
    @FXML
    public  TextField itemName;
     @FXML
    public  TextField amount;
    
    
    
    public static String h=" a";
   static Seller seller= new Seller("","");
   ArrayList<Item> arrayListItem ;
   Insert insert= new Insert();
   ObservableList<String> list;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        username.setText(seller.getUsername());
         updateView();
        
    }    
    @FXML
    public void upload(ActionEvent event){
        newUpload.toFront();
        uploadButton.setVisible(false);
        backButton.setVisible(true);
    }
    @FXML
    public void back(ActionEvent event){
        uploadButton.setVisible(true);
        backButton.setVisible(false);
        newUpload.toBack();
        viewPost.toFront();
    }
     @FXML
    public void post(ActionEvent event){
     
    String name= itemName.getText();
    String stringAmount=(amount.getText());
    System.out.println("aaa"+stringAmount);
    double amountMoney=Double.parseDouble(stringAmount);
    String catagoryName="fashion";
    System.out.println("catagory NAme:"+ catagoryName);
    Item item= new Item(name, catagoryName,seller.getUsername());
    item.setAmount(amountMoney);
    newUpload.toBack();
    
    insert.insert(item);
    updateView();
     
    
    }

private void updateView() {
    try{
    Retrive retrive = new Retrive();
    arrayListItem =retrive.retrive(username.getText());
    System.out.println("list item"+arrayListItem);
    list= FXCollections.observableArrayList();
    
    
    for(Item i : arrayListItem){
        String last =i.getName()+"\n"+"\n"+i.getCatagory();
        list.add(last);
    }
    listView.setItems(list);
    }
    catch(Exception ex){
        System.out.println("insert full name");
    
    }
    }
 @FXML
    public void logout(ActionEvent event){
        //            SwitchScene s = new SwitchScene();
        switchScene("Home.fxml",event);
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
