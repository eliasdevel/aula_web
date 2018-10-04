package controllers;

import dao.CategorieDao;
import dao.ImagesDao;
import dao.ProductsDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;
import models.Image;
import models.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ProductSave implements Logic {

    public String executa(HttpServletRequest req,
            HttpServletResponse res)
            throws Exception {
        System.out.println(req.getParameter("ac"));
        ProductsDao dao = new ProductsDao(new ArrayList<Product>());
        ImagesDao imgsDao = new ImagesDao(new ArrayList<Image>());

        CategorieDao catDao = new CategorieDao(new ArrayList<Categorie>());

        Product product = new Product();
        System.out.println("Parametro de categoria: " + req.getParameter("price"));
        if (req.getParameter("category") != null) {
            System.out.println("Entrou na jabiraca");
            product.setCategorie(catDao.getCategorie(req.getParameter("category")));

        }
        if (req.getParameter("id") != null) {
            product.setId(Integer.parseInt(req.getParameter("id")));
        }
        if (req.getParameter("name") != null) {
            product.setName(req.getParameter("name"));
        }
        if (req.getParameter("description") != null) {
        
            

            product.setDescription( req.getParameter("description"));
        }
        if (req.getParameter("price") != null) {
            product.setPrice(Float.parseFloat(req.getParameter("price")));
        }

//        for (int i = 0; i < images.length; i++) {
//            System.out.println("img:" + images[i]);
//
//        }
        if (req.getParameter("ac") != null) {
            if (req.getParameter("ac").equals("delete")) {
                imgsDao.delete(dao.getProduct(Integer.parseInt(req.getParameter("id"))));
                dao.delete("products", req.getParameter("id"));
            }
        } else {
            if (dao.saveProduct(product)) {
                if (req.getParameter("id") == null) {
                    product.setId(dao.currentInteger("products"));
                }
                String[] images = req.getParameterValues("images-hd[]");
                imgsDao.delete(product);
                if (images != null) {
                    for (int i = 0; i < images.length; i++) {
                        System.out.println("img:" + images[i]);
                        Image img = new Image();
                        img.setBase64Data(images[i]);
                        img.setProduct(product);
                        img.setName("img");
                        img.setLabel("img1");
                        imgsDao.saveImage(img);
                    }
                }
                req.setAttribute("type-msg", "sucess");
                req.setAttribute("msg", "Salvo com sucesso");
            } else {
                req.setAttribute("type-msg", "error");
                req.setAttribute("msg", "Erro ao salvar");
            }
        }
        req.setAttribute("url", "?p=Products");
        return "reload.jsp";
    }
}
