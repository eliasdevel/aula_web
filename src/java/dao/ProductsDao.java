/*
 */
package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Categorie;
import models.Image;
import models.Product;

/**
 *
 * @author elias
 */
public class ProductsDao extends Standart {

    private List<Product> products;
    private CategorieDao categoriesDao;

    public ProductsDao(List<Product> products) {
        this.con = con;
        this.products = products;
    }

    /**
     *
     * @return List of products
     * @throws SQLException
     */
    public List<Product> getProducts(Product productQ) throws SQLException {
        String query = "SELECT * FROM products ";
        if (productQ != null) {
            query += "where name like ?";
        }
        query += " ORDER BY id";
        PreparedStatement ps = this.con.prepareStatement(query + ";");

        if (productQ != null) {
            ps.setString(1,"%"+ productQ.getName()+"%");
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            //Setters
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getFloat("price"));
            product.setDescription(rs.getString("description"));
            product.setImages(new ImagesDao(new ArrayList<Image>()).getImages(product));
            this.products.add(product);
            //turn null, "minha mania"
            product = null;
        }
        return this.products;
    }

    public boolean saveProduct(Product product) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = this.getById("products", product.getId() + "");
        if (rs.next()) {
            ps = this.con.prepareStatement("UPDATE products set name  = ? , description = ?, price = ? ,category_id =?  where id = ?;");
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setFloat(3, product.getPrice());
            ps.setInt(4, product.getCategorie().getId());
            ps.setInt(5, product.getId());
        } else {
            ps = this.con.prepareStatement("INSERT INTO products (description,name,price,category_id) values(?,?,?,?);");
            ps.setString(1, product.getDescription());
            ps.setString(2, product.getName());
            ps.setFloat(3, product.getPrice());
            ps.setInt(4, product.getCategorie().getId());
        }
        return !ps.execute();
    }

    public Product getProduct(int id) throws SQLException {
        this.categoriesDao = new CategorieDao(new ArrayList<Categorie>());
        ResultSet rs = this.getById("products", id + "");
        rs.next();
        Product c = new Product();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setDescription(rs.getString("description"));
        c.setPrice(rs.getFloat("price"));
        c.setCategorie(this.categoriesDao.getCategorie(rs.getString("category_id")));
        return c;
    }

}
