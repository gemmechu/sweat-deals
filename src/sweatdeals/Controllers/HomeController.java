/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals.Controllers;

import sweatdeals.*;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import static sweatdeals.Controllers.FeedBackController.username;


/**
 *
 * @author ThinkPad
 */
public class HomeController implements Initializable {
    
 

@FXML
    public  ListView listView;
    ObservableList<String> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateView();
        
    }
   @FXML
    public void goToLogin(ActionEvent event){
        switchScene("Login.fxml",event);
        
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
   private void updateView() {
    ArrayList<Item> arrayListItem= new ArrayList<>();
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
    public void goToAdminLogin(ActionEvent event){
     switchScene("AdminLogin.fxml",event);
        
    }
    
}
