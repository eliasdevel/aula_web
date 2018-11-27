package controllers;

import dao.ProductsDao;
import helpers.PagesMap;
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
public class Products implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        //Search
        req.setAttribute("page", "Products");
        Map<String, String> searchColumns = new HashMap<>();
        Map<String, String> searchValues = new HashMap<>();
        searchColumns.put("name", "Nome");
        searchValues.put("name", req.getParameter("name"));
        req.setAttribute("searchColumns", searchColumns);
        req.setAttribute("searchValues", searchValues);
        Product search = new Product();
        search.setName(searchValues.get("name"));
        if (req.getParameter("name") == null) {
            search = null;
        }
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
         int p = 0;
        if (req.getParameter("o") != null) {
            p = Integer.parseInt(req.getParameter("o"));
        }
        req.setAttribute("pageLinks", new PagesMap().getMap(dao.getPages("products"), "?p=Products"));
        req.setAttribute("products", dao.getProducts(search,p*10));
        
        req.setAttribute("currentPage", p);
        req.setAttribute("content", "products-list.jsp");
        req.setAttribute("savePage", "ProductForm");
        req.setAttribute("title", "Products");
        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }

}
