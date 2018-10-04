package controllers;

import dao.CitysDao;
import dao.StatesDao;
import dao.ProductsDao;
import dao.CategorieDao;
import dao.ImagesDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;
import models.City;
import models.Image;
import models.State;
import models.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ProductForm implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println(req.getParameter("ac"));

        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        CategorieDao categorieDao = new CategorieDao(new ArrayList<Categorie>());
        ImagesDao imagesDao = new ImagesDao(new ArrayList<Image>());
        Product product = new Product();
        String action = "admin?p=ProductSave";
        req.setAttribute("users", dao.getProducts(null));
        req.setAttribute("content", "product-form.jsp");
        req.setAttribute("title", "Edição Produto");
        if (req.getParameter("id") != null) {
            ResultSet rs = dao.getById("products", req.getParameter("id"));
            rs.next();
            product = dao.getProduct(Integer.parseInt(req.getParameter("id")));
            action += "&id=" + req.getParameter("id");
            req.setAttribute("product", product);
        }

//        Map<String, String> tipos = new HashMap<>();
//
//        tipos.put("R", "Administrador");
//        tipos.put("N", "Cliente");
        req.setAttribute("categories", categorieDao.getCategories(null));
        req.setAttribute("action", action);
        req.setAttribute("images", imagesDao.getImages(product));

        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }

}
