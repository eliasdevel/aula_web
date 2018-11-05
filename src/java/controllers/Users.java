package controllers;

import dao.StatesDao;
import dao.UsersDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.User;

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
        
        
        UsersDao dao = new UsersDao(new ArrayList<User>());
        req.setAttribute("users", dao.getUsers(search));
        req.setAttribute("content", "users-list.jsp");
        req.setAttribute("savePage", "UserForm");
        req.setAttribute("title", "Users");
        System.out.println("Executando a logica e redirecionando...");
        return "layout.jsp";
    }
  
}
