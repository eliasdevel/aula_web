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
public class Orders extends HeaderContents {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        req.setAttribute("title", "Login");
        req.setAttribute("content", "orders.jsp");
        System.out.println("Executando a logica e redirecionando...");

        return super.executa(req, res);
    }

}
