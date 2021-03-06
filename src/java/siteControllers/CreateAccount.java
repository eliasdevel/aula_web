package siteControllers;

import dao.ProductsDao;
import dao.CategorieDao;
import dao.CitysDao;
import dao.StatesDao;
import dao.UsersDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.City;
import models.State;
import models.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CreateAccount implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        UsersDao dao = new UsersDao(new ArrayList<User>());

        CitysDao citysDao = new CitysDao(new ArrayList<City>());
        StatesDao statesDao = new StatesDao(new ArrayList<State>());

        String action = "?p=AccountSave";
        req.setAttribute("users", dao.getUsers(null, 0));
        req.setAttribute("content", "user-form.jsp");
        req.setAttribute("title", "Usuarios");
        if (req.getParameter("id") != null) {
            ResultSet rs = dao.getById("users", req.getParameter("id"));
            rs.next();
            User user = dao.getUser(Integer.parseInt(req.getParameter("id")));
            action += "&id=" + req.getParameter("id");
            req.setAttribute("user", user);
        }
        req.setAttribute("action", action);
        req.setAttribute("states", statesDao.getStates(null));
        req.setAttribute("citys", citysDao.getCitys(null));
        
        System.out.println("Executando a logica e redirecionando...");
        return "sitePages/layout.jsp";
    }

}
