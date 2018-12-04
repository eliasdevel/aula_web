package controllers;

import dao.UsersDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import helpers.PagesMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Users implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        //Search
        req.setAttribute("page", "Users");
        Map<String, String> searchColumns = new HashMap<>();
        Map<String, String> searchValues = new HashMap<>();
        searchColumns.put("name", "Nome");
        searchValues.put("name", req.getParameter("name"));
        req.setAttribute("searchColumns", searchColumns);
        req.setAttribute("searchValues", searchValues);
        User search = new User();
        search.setName(searchValues.get("name"));
        if (req.getParameter("name") == null) {
            search = null;
        }

        //Search
        int p = 0;
        if (req.getParameter("o") != null) {
            p = Integer.parseInt(req.getParameter("o"));
        }
        UsersDao dao = new UsersDao(new ArrayList<User>());
        req.setAttribute("pageLinks", new PagesMap().getMap(dao.getPages("users"), "?p=Users"));
        
        req.setAttribute("currentPage",p);
        req.setAttribute("users", dao.getUsers(search, p * 10));
        req.setAttribute("content", "users-list.jsp");
        req.setAttribute("savePage", "UserForm");
        req.setAttribute("title", "Users");
        System.out.println("Executando a logica e redirecionando...");
        dao.closeConnection();
        return "layout.jsp";
    }

}
