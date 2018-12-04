/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siteControllers;

import dao.CategorieDao;
import dao.LoginDao;
import dao.ProductsDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;
import models.Product;

/**
 *
 * @author elias
 */
public class HeaderContents implements Logic {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        CategorieDao catDao = new CategorieDao(new ArrayList<Categorie>());
        Map<String, String> searchColumns = new HashMap<>();
        Map<String, String> searchValues = new HashMap<>();
        searchValues.put("keyword", req.getParameter("keyword"));
        req.setAttribute("searchColumns", searchColumns);
        req.setAttribute("searchValues", searchValues);
        Product search = new Product();

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
        pd = (ArrayList<Product>) dao.getProducts(search, 0);
        if (pd.size() == 0) {
            req.setAttribute("noResult", "Nenhum resultado encontrado para pesquisa! ");
        }
        req.setAttribute("products", pd);
        req.setAttribute("categories", catDao.getCategories(null));

        req.setAttribute("title", "iTrago");
        req.setAttribute("cartNumbers", new Cart(req).getCart(req));
        req.setAttribute("cartProducts", dao.getProductsInList(new Cart(req).getCart(req)));
        LoginDao lDao = new LoginDao(req.getSession());

        if (lDao.normalClientlogged()) {
            req.setAttribute("clientData", lDao.getLoggedUser());
        }

        lDao.closeConnection();
        dao.closeConnection();
        return "sitePages/layout.jsp";
    }

}
