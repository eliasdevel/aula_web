package siteControllers;

import controllers.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Logout extends Login {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        req.getSession().removeAttribute("email");
        req.getSession().removeAttribute("password");

        return super.executa(req, res);
    }

}
