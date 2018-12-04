/*
 */
package dao;

import java.sql.PreparedStatement;
import java.util.List;
import models.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Order;

/**
 *
 * @author elias
 */
public class OrdersDao extends Standart {

    private List<Order> citys;
    private StatesDao statesDao;

    public OrdersDao(List<Order> orders) {
        this.con = con;
        this.citys = citys;
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
            ps = this.con.prepareStatement("insert into orders (users_id,products_id,quantity,closed) values(?,?,?,?);");
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getProd().getId());
            ps.setFloat(3, order.getQuantity());
            ps.setFloat(4, order.getClosed());
        }
        return ps.execute();
    }

   

}
