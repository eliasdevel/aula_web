package siteControllers;

import controllers.*;
import dao.LoginDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Login extends HeaderContents {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        req.getSession().setAttribute("email", req.getParameter("email"));
        req.getSession().setAttribute("password", req.getParameter("password"));
        req.setAttribute("email", req.getSession().getAttribute("email"));
        req.setAttribute("password", req.getSession().getAttribute("password"));

        HttpSession session = req.getSession();
        boolean logged = false;
        try {
            logged = new LoginDao(session).normalClientlogged();
        } catch (SQLException ex) {

        }
        Boolean tried = false;
        if (req.getParameter("t") != null) {
            tried = true;
        }
        if (tried && logged) {
            req.setAttribute("url", "?p=Home");
            return "reload.jsp";
        }
        req.setAttribute("title", "Login");
        req.setAttribute("content", "login.jsp");
        System.out.println("Executando a logica e redirecionando...");

        return super.executa(req, res);
    }

}
