package controllers;

import dao.CitysDao;
import dao.UsersDao;
import dao.AddressDao;
import dao.CategorieDao;
import dao.ProductsDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Address;
import models.Categorie;
import models.City;
import models.Product;
import models.State;
import models.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ProductSave implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println(req.getParameter("ac"));
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        CategorieDao catDao = new CategorieDao(new ArrayList<Categorie>());

        Product product = new Product();
        System.out.println("Parametro de categoria: " + req.getParameter("price"));
        if (req.getParameter("category") != null) {
            System.out.println("Entrou na jabiraca");
            product.setCategorie(catDao.getCategorie(req.getParameter("category")));

        }
        if (req.getParameter("id") != null) {
            product.setId(Integer.parseInt(req.getParameter("id")));
        }
        if (req.getParameter("name") != null) {
            product.setName(req.getParameter("name"));
        }
        if (req.getParameter("description") != null) {
            product.setDescription(req.getParameter("description"));
        }
        if (req.getParameter("price") != null) {
            product.setPrice(Float.parseFloat(req.getParameter("price")));
        } 
        String[] images = req.getParameterValues("images-hd[]");
       

        
        

   

    if (req.getParameter ( 
        "ac") != null) {
            if (req.getParameter("ac").equals("delete")) {
            dao.delete("products", req.getParameter("id"));
        }
    }

    
        else {
            if (dao.saveProduct(product)) {
            req.setAttribute("type-msg", "sucess");
            req.setAttribute("msg", "Salvo com sucesso");
        } else {
            req.setAttribute("type-msg", "error");
            req.setAttribute("msg", "Erro ao salvar");
        }
    }

    req.setAttribute (
    "url", "?p=Products");

return "reload.jsp";
    }
}
