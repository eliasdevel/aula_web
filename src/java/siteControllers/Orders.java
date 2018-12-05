package siteControllers;

import controllers.*;
import dao.LoginDao;
import dao.OrdersDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Orders extends HeaderContents {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

        OrdersDao orDao = new OrdersDao(new ArrayList<Order>());
        LoginDao lgDao = new LoginDao(req.getSession());
        
        req.setAttribute("title", "Orders");
        req.setAttribute("content", "orders.jsp");
        System.out.println("Executando a logica e redirecionando...");
        if(lgDao.getLoggedUser() !=null){
            req.setAttribute("orders", orDao.getOrderByUser(lgDao.getLoggedUser()));
        }
        
            
        orDao.closeConnection();
        
        return super.executa(req, res);
    }

}
