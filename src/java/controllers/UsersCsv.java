package controllers;

import dao.StatesDao;
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
public class UsersCsv implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        //Search
        res.setContentType("application/csv");
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

        req.setAttribute("currentPage", p);
        ArrayList<User> users = (ArrayList<User>) dao.getUsers(search, p * 10);
        String output ="";
        for(User user: users){
            output += user.getEmail() + "; " + user.getName() + "\r\n";
        }
        req.setAttribute("content", "csv.jsp");
        req.setAttribute("data", output);
        return "layout.jsp";
    }

}
