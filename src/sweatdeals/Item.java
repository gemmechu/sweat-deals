/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweatdeals;

/**
 *
 * @author ThinkPad
 */
public class Item {
    String name;
    String catagory;
    String sellerName;
    String buyerName;
    int Bogus;
    int id;
    int number;
    double amount;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    int status;

    public Item(){
        this.name=null;
        this.catagory=null;
    }
    public Item(String name, String catagory) {
        this.name = name;
        this.catagory = catagory;
        
    }
    public Item(String name, String catagory, String sellerName) {
        this.name = name;
        this.catagory = catagory;
        this.sellerName = sellerName;
      
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setBogus(int Bogus) {
        this.Bogus = Bogus;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public int getBogus() {
        return Bogus;
    }

    public int getStatus() {
        return status;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getName() {
        return name;
    }

    public String getCatagory() {
        return catagory;
    }

     public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
}
