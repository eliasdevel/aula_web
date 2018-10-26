package controllers;

import dao.CategorieDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;
import models.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Categories implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        Map<String, String> searchColumns = new HashMap<>();
        Map<String, String> searchValues = new HashMap<>();
        searchColumns.put("name", "Nome");
        searchValues.put("name", req.getParameter("name"));

        Categorie search = new Categorie();
        search.setName(searchValues.get("name"));
        if (req.getParameter("name") == null) {
            search = null;
        }

        CategorieDao dao = new CategorieDao(new ArrayList<Categorie>());
        req.setAttribute("categories", dao.getCategories(search));

        req.setAttribute("content", "categories-list.jsp");
        req.setAttribute("savePage", "CategorieForm");
        req.setAttribute("title", "Categorias");
        req.setAttribute("page", "Categories");
        req.setAttribute("searchColumns", searchColumns);
        req.setAttribute("searchValues", searchValues);

        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }

}
