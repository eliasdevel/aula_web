package controllers;

import dao.CitysDao;
import dao.StatesDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.City;
import models.State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CitySave implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println(req.getParameter("ac"));
        java.lang.reflect.Method method;
        CitysDao dao = new CitysDao(new ArrayList<City>());
        StatesDao stDao = new StatesDao(new ArrayList<State>());
        City city = new City();

        if (!req.getParameter("id").equals("") ) {
            city.setId(Integer.parseInt(req.getParameter("id")));
        }
        if (req.getParameter("state_id") != null) {
            city.setState(stDao.getState(req.getParameter("state_id")));
        }
        if (req.getParameter("name") != null) {
            city.setName(req.getParameter("name"));
        }

        if (req.getParameter("ac") != null) {
            if (req.getParameter("ac").equals("delete")) {
                dao.delete("citys", city.getId() + "");
            }
        } else {
            if (dao.saveCity(city)) {
                req.setAttribute("type-msg", "sucess");
                req.setAttribute("msg", "Salvo com sucesso");
            } else {
                req.setAttribute("type-msg", "error");
                req.setAttribute("msg", "Erro ao salvar");
            }
        }
        dao.closeConnection();
        stDao.closeConnection();
        req.setAttribute("url", "?p=Cities");
        return "reload.jsp";
    }
}
