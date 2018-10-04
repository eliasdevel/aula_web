/*
 */
package dao;

import java.sql.PreparedStatement;
import java.util.List;
import models.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Image;
import models.Product;

/**
 *
 * @author elias
 */
public class ImagesDao extends Standart {

    private List<Image> images;

    public ImagesDao(List<Image> images) {
        this.con = con;
        this.images = images;
    }

    /**
     *
     * @return List of images
     * @throws SQLException
     */
    public List<Image> getImages(Product prod) throws SQLException {
        String query = "SELECT * FROM images ";
        if (prod != null) {
            query += " product_id  = ? ";
        }

        PreparedStatement ps = this.con.prepareStatement(query + ";");

        if (prod != null) {
            ps.setInt(1, prod.getId());
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Image image = new Image();
            //Setters
            image.setId(rs.getInt("id"));
            image.setName(rs.getString("name"));
            image.setLabel(rs.getString("label"));
            image.setBase64Data(rs.getString("base64data"));
            this.images.add(image);

            //turn null, "minha mania"
            image = null;
        }
        return this.images;
    }

    public boolean saveImage(Image image) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = this.getById("images", "" + image.getId());
        if (rs.next()) {
            ps = this.con.prepareStatement("UPDATE images set id = ? , name  = ? ,label = ?, base64data = ? where id = ?;");
            ps.setInt(1, image.getId());
            ps.setString(2, image.getName());
            ps.setString(3, image.getLabel());
            ps.setString(4, image.getBase64Data());
            ps.setInt(5, image.getId());
        } else {
            ps = this.con.prepareStatement("insert into images (name,label,base64data) values(?,?,?,select curval());");
            ps.setString(1, image.getName());
            ps.setString(2, image.getLabel());
            ps.setString(3, image.getBase64Data());

        }
        return ps.execute();
    }

    public boolean delete(Image image) throws SQLException {
        PreparedStatement ps = this.con.prepareStatement("DELETE FROM images where id = ?;");
        ps.setInt(1, image.getId());
        return ps.execute();
    }

    public Image getImage(String id) throws SQLException {
        ResultSet rs = this.getById("images", id);
        rs.next();
        Image c = new Image();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setLabel(rs.getString("label"));
        c.setBase64Data(rs.getString("base64data"));
        return c;
    }

}
