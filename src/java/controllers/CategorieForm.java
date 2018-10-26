package controllers;

import dao.CategorieDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;
import models.State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CategorieForm implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println(req.getParameter("ac"));
        java.lang.reflect.Method method;

        CategorieDao dao = new CategorieDao(new ArrayList<Categorie>());
        
        String action = "admin?p=CategorieSave";
        req.setAttribute("categories", dao.getCategories(null));
        req.setAttribute("content", "categorie-form.jsp");
        req.setAttribute("title", "Categorias");
        if (req.getParameter("id") != null) {
            ResultSet rs = dao.getById("categories", req.getParameter("id"));
            rs.next();
            Categorie cate = new Categorie();
            action += "&id=" + req.getParameter("id");
            cate.setId(Integer.parseInt(req.getParameter("id")));
            cate.setName(rs.getString("name"));
            req.setAttribute("categorie", cate);
        }

        req.setAttribute("action", action);
        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }

}
