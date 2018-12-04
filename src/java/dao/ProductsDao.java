/*
 */
package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
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
     * @return List of products
     * @throws SQLException
     */
    public List<Product> getProducts(Product search, int offset) throws SQLException {
        String query = "SELECT * FROM products ";
        if (search != null) {
            query += " where name ilike ?";
            if (search.getCategorie() != null) {
                query += " and category_id = ?";
            }
        }
        query = this.addOffset(query);
        PreparedStatement ps = this.con.prepareStatement(query + ";");

        int indexParm = 1;
        if (search != null) {
            ps.setString(indexParm, "%" + search.getName() + "%");
            indexParm++;
            if (search.getCategorie() != null) {
                ps.setInt(indexParm, search.getCategorie().getId());
                indexParm++;
            }

        }

        ps.setInt(indexParm, offset);
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

    public List<Product> getProductsInList(Map<Integer, Float> productIds) throws SQLException {
        this.products = new ArrayList<Product>();
        if (productIds.size() < 1) {
            return new ArrayList<Product>();
        }
        String query = "SELECT count(id)as quantity, * FROM products ";
        query += " where id in (";
        for (int i = 0; i < productIds.size() - 1; i++) {
            query += "?,";
        }
        query += "?) group by id,name,price,description;";

        PreparedStatement ps = this.con.prepareStatement(query + ";");
        int i = 1;
        for (Map.Entry<Integer, Float> entry : productIds.entrySet()) {
            ps.setInt(i, entry.getKey());
            i++;
        }
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            //Setters
            product.setQuantity(rs.getFloat("quantity"));
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getFloat("price"));
            product.setDescription(rs.getString("description"));

            ImagesDao imgDao = new ImagesDao(new ArrayList<Image>());
            product.setImages(imgDao.getImages(product));
            imgDao.closeConnection();
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
            System.out.println("product.getDescription()");
            System.out.println(product.getDescription());
            ps.setString(1, product.getDescription());
            ps.setString(2, product.getName());
            ps.setFloat(3, product.getPrice());
            ps.setInt(4, product.getCategorie().getId());
        }
        return !ps.execute();
    }

    public Product getProduct(int id) throws SQLException {
        this.categoriesDao = new CategorieDao(new ArrayList<Categorie>());
        PreparedStatement ps = this.con.prepareStatement("Select * from  products where id = ?;");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Product c = new Product();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setDescription(rs.getString("description"));
        c.setPrice(rs.getFloat("price"));
        c.setCategorie(this.categoriesDao.getCategorie(rs.getString("category_id")));
        c.setImages(new ImagesDao(new ArrayList<Image>()).getImages(c));
        return c;
    }
}
