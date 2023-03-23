/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author binla
 */
public class OrderListFacade {
    public int add(Item item,int userId,Date issueDate) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into orderList values (?,?,?,?)");
        stm.setString(1, item.getProduct().getProductId());
        stm.setInt(2, userId);
        stm.setDouble(3, item.getTotal());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(issueDate));
        int count = stm.executeUpdate();
        return count;
    }
    public int count(String productId) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select count(product_id) 'count' from orderList where product_id = ? group by product_id");
        stm.setString(1, productId);
        ResultSet rs = stm.executeQuery();
        int count = rs.getInt("count");
        return count;
    }
    public List<String> select() throws SQLException {
        List<String> list = new ArrayList<String>();
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select product_id from orderList group by product_id");
        while(rs.next()){
            list.add(rs.getString("product_id"));
        }
        return list;
    }
}
