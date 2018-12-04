package siteControllers;

import dao.AddressDao;
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
import models.Address;
import models.City;
import models.State;
import models.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class AccountSave implements Logic  {
    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {

      System.out.println(req.getParameter("ac"));
        java.lang.reflect.Method method;
        UsersDao dao = new UsersDao(new ArrayList<User>());
        CitysDao citysDao = new CitysDao(new ArrayList<City>());
        AddressDao addressDao = new AddressDao(new ArrayList<Address>());

        User user = new User();

        Address address = new Address();

        if (req.getParameter("id") != null) {
            user.setId(Integer.parseInt(req.getParameter("id")));
        }
        if (req.getParameter("name") != null) {
            user.setName(req.getParameter("name"));
        }
        if (req.getParameter("email") != null) {
            user.setEmail(req.getParameter("email"));
        }
        if (req.getParameter("cpf") != null) {
            user.setCpf(req.getParameter("cpf"));
        }
      
           user.setType("N");
        

        if (req.getParameter("cep") != null) {
            address.setCep(req.getParameter("cep"));
        }
        if (req.getParameter("street") != null) {
            address.setStreet(req.getParameter("street"));
        }
        if (req.getParameter("password") != null) {
            user.setPassword(req.getParameter("password"));
        }

        if (req.getParameter("city") != null) {
            address.setCity(citysDao.getCity(Integer.parseInt(req.getParameter("city"))));

//            user.getAddress().setCity(citysDao.getCity(0)));
        }

        user.setAddress(address);
        if (req.getParameter("ac") != null) {
            if (req.getParameter("ac").equals("delete")) {
                dao.delete("users", req.getParameter("id"));
            }
        } else {
            addressDao.saveAddress(address);
            if (dao.saveUser(user)) {
                req.setAttribute("type-msg", "sucess");
                req.setAttribute("msg", "Salvo com sucesso");
            } else {
                req.setAttribute("type-msg", "error");
                req.setAttribute("msg", "Erro ao salvar");
            }
        }

        req.setAttribute("url", "?p=Home");
        return "reload.jsp";
    }

}
