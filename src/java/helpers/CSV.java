/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;
import models.Order;

/**
 *
 * @author elias
 */
public class CSV {

    String csv;

    public String getOrdersCsv(ArrayList<Order> orders) {
        this.csv ="ID;Data;Cliente;Produto;Preço;Quantidade;Total\r\n";
        for (Order ord : orders) {
            this.csv += ord.getId() + ";" + ord.getFormatedDate() + ";" + ord.getUser().getName() + ";"
                    + "" + ord.getProd().getName() + ";" + ord.getProd().getPrice() + ";" + ord.getQuantity() + ";"
                    + "" + (ord.getQuantity() * ord.getProd().getPrice())+"\r\n";
        }

        return csv;
    }

}
