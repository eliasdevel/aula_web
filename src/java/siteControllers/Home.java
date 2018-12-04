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
public class Home extends HeaderContents {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        req.setAttribute("content", "home.jsp");
        System.out.println("Executando a logica e redirecionando...");
        return super.executa(req, res);
    }

}
