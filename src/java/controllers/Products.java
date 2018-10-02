package controllers;

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
public class Products implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        req.setAttribute("products", dao.getProducts(null));
        req.setAttribute("content", "products-list.jsp");
        req.setAttribute("savePage", "ProductForm");
        req.setAttribute("title", "Products");
        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }
  
}
