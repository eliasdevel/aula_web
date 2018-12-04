package siteControllers;

import dao.ProductsDao;
import dao.OrdersDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CheckoutCart extends Home {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        Cart crt = new Cart(req);
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        OrdersDao orDao = new OrdersDao(new ArrayList<Order>());
        Order ord = new Order();
        
        
        req.getAttribute("");
        
        dao.closeConnection();
        orDao.closeConnection();
        return super.executa(req, res);
    }

}
