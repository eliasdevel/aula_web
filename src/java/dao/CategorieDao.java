/*
 */
package dao;

import java.sql.PreparedStatement;
import java.util.List;
import models.Categorie;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elias
 */
public class CategorieDao extends Standart {

    private List<Categorie> categories;

    public CategorieDao(List<Categorie> categories) {
        this.con = con;
        this.categories = categories;
    }

    /**
     *
     * @return List of categories
     * @throws SQLException
     */
    public List<Categorie> getCategories(Categorie categorieQ) throws SQLException {
        String query = "SELECT * FROM categories ";
        if (categorieQ != null) {
            query += "where name like ?";
        }

        PreparedStatement ps = this.con.prepareStatement(query + ";");

        if (categorieQ != null) {
            ps.setString(1, "%"+categorieQ.getName()+"%");
        }
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Categorie categorie = new Categorie();
            //Setters
            categorie.setId(rs.getInt("id"));
            categorie.setName(rs.getString("name"));
            categorie.setDescription(rs.getString("description"));
            this.categories.add(categorie);
            System.out.println("Teste: ");
            System.out.println(categorie.getName());
            //turn null, "minha mania"
            categorie = null;
        }
        return this.categories;
    }

    public boolean saveCategorie(Categorie categorie) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = this.getById("categories", "" + categorie.getId());
        if (rs.next()) {
            ps = this.con.prepareStatement("UPDATE categories set description = ? , name  = ? where id = ?;");
            ps.setString(1, categorie.getDescription());
            ps.setString(2, categorie.getName());
            ps.setInt(3, categorie.getId());
        } else {
            ps = this.con.prepareStatement("insert into categories (name,description) values(?,?);");
            ps.setString(1, categorie.getName());
            ps.setString(2, categorie.getDescription());
        }
        return ps.execute();
    }

    public Categorie getCategorie(String id) throws SQLException {
        ResultSet rs = this.getById("categories", id);
        rs.next();
        Categorie c = new Categorie();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));

        c.setDescription(rs.getString("description"));
        return c;
    }

}
