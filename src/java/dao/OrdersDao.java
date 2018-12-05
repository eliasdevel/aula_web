/*
 */
package dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import models.Image;
import models.Order;
import models.Product;
import models.User;

/**
 *
 * @author elias
 */
public class OrdersDao extends Standart {

    private List<Order> orders;
    private StatesDao statesDao;

    public OrdersDao(List<Order> orders) {
        this.con = con;
        this.orders = orders;
    }

    /**
     *
     * @return List of citys
     * @throws SQLException
     */
    public boolean saveOrder(Order order) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = this.getById("orders", order.getId() + "");
        if (rs.next()) {
            ps = this.con.prepareStatement("UPDATE orders users_id  = ? ,products_id = ? ,quantity = ?,closed = ?  where id = ?;");
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getProd().getId());
            ps.setFloat(3, order.getQuantity());
            ps.setFloat(4, order.getClosed());
            ps.setInt(5, order.getId());
        } else {
            ps = this.con.prepareStatement("insert into orders (users_id,products_id,quantity,closed,data) values(?,?,?,?,now());");
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getProd().getId());
            ps.setFloat(3, order.getQuantity());
            ps.setString(4, order.getClosed() + "");
        }
        return ps.execute();
    }

    public List<Order> getOrderByUser(User usr) throws SQLException {
        this.orders = new ArrayList<Order>();

        String query = "SELECT * FROM orders ";
        query += " where  users_id = ?";

        PreparedStatement ps = this.con.prepareStatement(query + ";");
        ps.setInt(1, usr.getId());
        
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Order order = new Order();
            //Setters
            order.setUser(usr);
            ProductsDao pdao = new ProductsDao(new ArrayList<Product>());
            order.setProd(pdao.getProduct(rs.getInt("products_id")));
            order.setQuantity(rs.getFloat("quantity"));
            order.setClosed( rs.getString("closed").charAt(0));
            order.setData(rs.getDate("data"));
           
            this.orders.add(order);
            //turn null, "minha mania"
            order = null;
        }
        return this.orders;
    }

}
