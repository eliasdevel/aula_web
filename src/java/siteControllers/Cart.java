/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siteControllers;

import java.util.HashMap;
import java.util.Map;
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
            Map<Integer, Float> productIds = new HashMap<>();
            req.getSession().setAttribute(this.cartName, productIds);
        }
    }

    public HttpSession addToCart(HttpServletRequest req, Product prod) {

        Map<Integer, Float> productIds = (Map<Integer, Float>) req.getSession().getAttribute(this.cartName);
        if (productIds.get(prod.getId()) != null) {
            productIds.put(prod.getId(), productIds.get(prod.getId()) + 1);
        } else {
            productIds.put(prod.getId(), (float) 1);
        }

        req.getSession().setAttribute(this.cartName, productIds);
        return req.getSession();
    }

    public HttpSession removeFromCart(HttpServletRequest req, Product prod) {
        Map<Integer, Float> productIds = (Map<Integer, Float>) req.getSession().getAttribute(this.cartName);
        if (productIds.get(prod.getId()) > 1) {
            productIds.put(prod.getId(), productIds.get(prod.getId()) - 1);
        } else {
            productIds.remove(prod.getId());
        }

        req.getSession().setAttribute(this.cartName, productIds);
        return req.getSession();
    }

    public Map<Integer, Float> getCart(HttpServletRequest req) {
        Map<Integer, Float> productIds = (Map<Integer, Float>) req.getSession().getAttribute(this.cartName);
        return productIds;
    }

    public void clearCart(HttpServletRequest req) {
        req.getSession().setAttribute(this.cartName, null);
    }

}
