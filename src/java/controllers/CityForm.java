package controllers;

import dao.CitysDao;
import dao.StatesDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.City;
import models.State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CityForm implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println(req.getParameter("ac"));
        StatesDao stDao = new StatesDao(new ArrayList<State>());
        req.setAttribute("states", stDao.getStates(null));

        CitysDao dao = new CitysDao(new ArrayList<City>());
        String action = "admin?p=CitySave";

        req.setAttribute("content", "city-form.jsp");
        req.setAttribute("title", "Cidades");
        if (req.getParameter("id") != null) {
            ResultSet rs = dao.getById("users", req.getParameter("id"));
            rs.next();
            City city = dao.getCity(Integer.parseInt(req.getParameter("id")));
            action += "&id=" + req.getParameter("id");
            req.setAttribute("city", city);
        }
        req.setAttribute("action", action);
        dao.closeConnection();
        stDao.closeConnection();
        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }
}
