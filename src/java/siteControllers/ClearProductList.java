package siteControllers;

import dao.ProductsDao;
import dao.CategorieDao;
import dao.LoginDao;
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
public class ClearProductList implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        Product search = new Product();
        CategorieDao catDao = new CategorieDao(new ArrayList<Categorie>());
        if (req.getParameter("category") != null) {
            if (!req.getParameter("category").equals("")) {
                req.setAttribute("category", catDao.getCategorie(req.getParameter("category")));
                search.setCategorie(catDao.getCategorie(req.getParameter("category")));
            }
        }

        search.setName(req.getParameter("keyword"));
        if (req.getParameter("keyword") == null) {
            search = null;
        }
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        ArrayList<Product> pd = new ArrayList<Product>();
        pd = (ArrayList<Product>) dao.getProducts(search, Integer.parseInt(req.getParameter("offsset")));
        if (pd.size() == 0) {
            req.setAttribute("noResult", "Nenhum resultado encontrado para pesquisa! ");
        }
        dao.closeConnection();
        catDao.closeConnection();
        req.setAttribute("products", pd);
        req.setAttribute("product-interaction", "home.jsp");
        System.out.println("Executando a logica e redirecionando...");
        return "sitePages/product-interaction.jsp";
    }

}
