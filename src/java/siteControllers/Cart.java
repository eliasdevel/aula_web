/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siteControllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.Product;

/**
 *
 * @author Elias
 */
public class Cart {

    String cartName = "productIds";

    public Cart(HttpServletRequest req) {
        if (req.getSession().getAttribute(this.cartName) == null) {
            ArrayList<Integer> productIds = new ArrayList<Integer>();
            req.getSession().setAttribute(this.cartName, productIds);
        }
    }

    public HttpSession addToCart(HttpServletRequest req, Product prod) {

        ArrayList<Integer> productIds = (ArrayList<Integer>) req.getSession().getAttribute(this.cartName);
        productIds.add(prod.getId());
        req.getSession().setAttribute(this.cartName, productIds);
        return req.getSession();
    }

    public HttpSession removeFromCart(HttpServletRequest req, Product prod) {
        ArrayList<Integer> productIds = (ArrayList<Integer>) req.getSession().getAttribute(this.cartName);
        productIds.remove(prod.getId());
        req.getSession().setAttribute(this.cartName, productIds);
        return req.getSession();
    }

    public ArrayList<Integer> getCart(HttpServletRequest req) {
        ArrayList<Integer> productIds = (ArrayList<Integer>) req.getSession().getAttribute(this.cartName);
        return productIds;
    }

}
