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
import javafx.stage.Stage;
import sweatdeals.DataBase.Buy;
import sweatdeals.Item;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class FeedBackController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label usernameLabel;
    @FXML
    private Label checkMark;
    public static String username;
       @FXML
    public  ListView listView;
    ObservableList<String> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             usernameLabel.setText(username);
             updateView();

    } 
    
    private void updateView() {
    ArrayList<Item> arrayListItem= new ArrayList<>();
    Retrive retrive = new Retrive();
    arrayListItem =retrive.retriveByUserName(username);
    
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
    public void gotoHome(ActionEvent event){
    switchScene("Buyer.fxml",event);
    }  
      @FXML
    public void bogus(ActionEvent event){
     ObservableList<String> name = listView.getSelectionModel().getSelectedItems();
     Retrive retrive= new Retrive();
     Item  item= new Item();
     item.setId(Integer.parseInt(name.get(0).substring(name.get(0).length()-2, name.get(0).length())));
     Item item2= retrive.retriveItemById(item.getId());
     Buy bogus= new Buy();
     bogus.markAsBogus(item);
     checkMark.setText("Item"+item2.getId()+"have been" +"\nMarked");
     
    } 
      public void Logout(ActionEvent event){
    switchScene("Home.fxml",event);
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
