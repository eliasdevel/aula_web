package siteControllers;

import dao.ProductsDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class AddToCart extends HeaderContents {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        Cart crt = new Cart(req);
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        if (req.getParameter("id") != null) {
            if (!req.getParameter("id").equals("")) {

                crt.addToCart(req, dao.getProduct(Integer.parseInt(req.getParameter("id"))));
            }
        }
        if (req.getParameter("redirect") != null) {
            req.setAttribute("url", "?p=" + req.getParameter("redirect"));
            req.setAttribute("content", "reload.jsp");
        }
        return super.executa(req, res);
    }

}
