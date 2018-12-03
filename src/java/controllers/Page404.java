package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Page404 implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

      
//        StatesDao dao = new StatesDao(new ArrayList<State>());
//
//        req.setAttribute("states", dao.getStates());
//        req.setAttribute("content", "states-list.jsp");
        req.setAttribute("title", "Página não encontrada");
        return "404.jsp";
    }

}
