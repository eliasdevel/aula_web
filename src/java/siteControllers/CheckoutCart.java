package siteControllers;

import dao.LoginDao;
import dao.ProductsDao;
import dao.OrdersDao;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CheckoutCart extends HeaderContents {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        Cart crt = new Cart(req);
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        OrdersDao orDao = new OrdersDao(new ArrayList<Order>());
        LoginDao lgDao = new LoginDao(req.getSession());
        if (!lgDao.normalClientlogged()) {
            req.setAttribute("url", "?p=Login");
            return "sitePages/reload.jsp";
        } else {
            Order ord = new Order();
            ord.setUser(lgDao.getLoggedUser());
            Map<Integer, Float> productIds = crt.getCart(req);

            for (Map.Entry<Integer, Float> entry : productIds.entrySet()) {
                ord.setProd(dao.getProduct(entry.getKey()));
                ord.setQuantity(entry.getValue());
                ord.setClosed('F');
                if (orDao.saveOrder(ord)) {

                }
            }
            crt.clearCart(req);
        }
        dao.closeConnection();
        orDao.closeConnection();
        req.setAttribute("url", "?p=Orders");
        return "sitePages/reload.jsp";
    }

}
