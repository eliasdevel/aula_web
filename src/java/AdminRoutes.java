
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elias
 */
public class AdminRoutes {

    String route;

    public String getRoute(String rt) {
        Map<String, Boolean> validPages = new HashMap<>();
        validPages.put("Home", true);
        validPages.put("Users", true);
        validPages.put("Login", true);
        validPages.put("Home", true);
        validPages.put("States", true);
        validPages.put("StateForm", true);
        validPages.put("StateSave", true);
        validPages.put("Users", true);
        validPages.put("UsersCsv", true);
        validPages.put("UserForm", true);
        validPages.put("UserSave", true);
        validPages.put("Cities", true);
        validPages.put("CityForm", true);
        validPages.put("CitySave", true);
        validPages.put("Logout", true);
        validPages.put("ProductForm", true);
        validPages.put("Products", true);
        validPages.put("ProductSave", true);
        validPages.put("Orders", true);
        validPages.put("CategorieForm", true);
        validPages.put("Categories", true);
        validPages.put("CategorieSave", true);
        if (validPages.get(rt)  == null ) {
            return "Page404";
        }

        return rt;
    }

}
