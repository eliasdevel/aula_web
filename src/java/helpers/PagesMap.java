package helpers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author elias
 */
public class PagesMap {

    public Map<Integer, String> getMap(int nPages, String link) {

        Map<Integer, String> pageLinks = new HashMap<>();

        for (int i = 0; i < nPages; i++) {
            pageLinks.put(i, link + "&o=" + i);
        }

        return pageLinks;
    }

}
