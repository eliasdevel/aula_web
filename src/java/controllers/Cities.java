package controllers;

import dao.CitysDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.City;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Cities implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        
        
        CitysDao dao = new CitysDao(new ArrayList<City>());
        req.setAttribute("cities", dao.getCitys(null));
        req.setAttribute("content", "cities-list.jsp");
        req.setAttribute("savePage", "CityForm");
        req.setAttribute("title", "Cidades");
        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }
  
}
