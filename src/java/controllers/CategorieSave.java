package controllers;

import dao.CategorieDao;
import dao.StatesDao;
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
public class CategorieSave implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        
        CategorieDao dao = new CategorieDao(new ArrayList<Categorie>());
        Categorie cat = new Categorie();
        if (req.getParameter("id") != null) {
            cat.setId(Integer.parseInt(req.getParameter("id")));
        }
        if (req.getParameter("name") != null) {
            cat.setName(req.getParameter("name"));
        }

        if (req.getParameter("ac") != null) {
            if (req.getParameter("ac").equals("delete")) {
                dao.delete("categories",  req.getParameter("id"));
            }

        } else {
            if (dao.saveCategorie(cat)) {
                req.setAttribute("type-msg", "sucess");
                req.setAttribute("msg", "Salvo com sucesso");
            } else {
                req.setAttribute("type-msg", "error");
                req.setAttribute("msg", "Erro ao salvar");
            }
        }

        req.setAttribute("url", "?p=Categories");
        return "reload.jsp";
    }
}
