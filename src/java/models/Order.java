/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author elias
 */
public class Order extends Standart {

    private Product prod;
    private float quantity;
    private User user;
    private char closed;
    private Timestamp data;

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public char getClosed() {
        return closed;
    }

    public void setClosed(char closed) {
        this.closed = closed;
    }

    public Timestamp getData() {

        return data;
    }

    public String getFormatedDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return format.format(data);
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

}
