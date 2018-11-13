package siteControllers;

import dao.ProductsDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Productp implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        req.setAttribute("product", dao.getProduct(Integer.parseInt(req.getParameter("id"))));
        System.out.println(req.getParameter("id"));
        req.setAttribute("content", "product.jsp");
        req.setAttribute("title", "iTrago");
        System.out.println("Executando a logica e redirecionando...");
        return "sitePages/layout.jsp";
    }

}
