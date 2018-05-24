/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals;

import java.util.ArrayList;

/**
 *
 * @author ThinkPad
 */
public class Seller {
    private String username;
    private String password;
    private ArrayList<Item> items;

    public Seller(String username, String password) {
        this.username = username;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
}
