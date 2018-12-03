
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
public class SiteRoutes {

    String route;

    public String getRoute(String rt) {
        Map<String, Boolean> validPages = new HashMap<>();
        validPages.put("Home", true);
        validPages.put("Productp", true);
        validPages.put("CreateAccount", true);
        validPages.put("AccountSave", true);
        if (validPages.get(rt)  == null ) {
            return "Page404";
        }

        return rt;
    }

}
