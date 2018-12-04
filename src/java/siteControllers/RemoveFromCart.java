package siteControllers;

import dao.ProductsDao;
import dao.CategorieDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.Categorie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class RemoveFromCart extends Home {
    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        Cart crt = new Cart(req);
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        if (req.getParameter("id") != null) {
            if (!req.getParameter("id").equals("")) {
                crt.removeFromCart(req, dao.getProduct(Integer.parseInt(req.getParameter("id"))));
            }
        }

        return super.executa(req, res);
    }

}
