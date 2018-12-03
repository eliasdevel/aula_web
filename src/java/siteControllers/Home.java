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
public class Home implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        Map<String, String> searchColumns = new HashMap<>();
        Map<String, String> searchValues = new HashMap<>();
        searchValues.put("keyword", req.getParameter("keyword"));
        req.setAttribute("searchColumns", searchColumns);
        req.setAttribute("searchValues", searchValues);
        Product search = new Product();
        search.setName(req.getParameter("keyword"));
        if (req.getParameter("keyword") == null) {
            search = null;
        }
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        req.setAttribute("products", dao.getProducts(search,0));
        req.setAttribute("content", "home.jsp");
        req.setAttribute("title", "iTrago");
        System.out.println("Executando a logica e redirecionando...");
        return "sitePages/layout.jsp";
    }

}
