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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VU HONG ANH
 */
public class CartFacade {

    public Cart select(int userId) throws SQLException {
        Cart cart = new Cart();
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select product_id, quantity from cart where user_id = ?");
        stm.setInt(1, userId);
        ResultSet rs = stm.executeQuery();
        List<Product> list = new ArrayList<>();
        ProductFacade pf = new ProductFacade();
        while (rs.next()) {
            Product product = pf.read(rs.getString("product_id"));
            int quantity = rs.getInt("quantity");
            cart.update(product, quantity);
        }
        return cart;
    }

    public boolean checkExist(int userId, String productId) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from cart where user_id = ? and product_id = ?");
        stm.setInt(1, userId);
        stm.setString(2, productId);
        ResultSet rs = stm.executeQuery();
        if(rs.next()) return true;
        return false;
    }

    public int add(int userId, String productId, int quantity) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into cart values (?,?,?)");
        stm.setInt(1, userId);
        stm.setString(2, productId);
        stm.setInt(3, quantity);
        int count = stm.executeUpdate();
        return count;
    }

    public int update(int userId, String productId, int quantity) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("update cart set quantity = ? where user_id = ? and product_id = ?");
        stm.setInt(1, quantity);
        stm.setInt(2, userId);
        stm.setString(3, productId);
        int count = stm.executeUpdate();
        return count;
    }

    public int empty(int userId) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from cart where user_id=?");
        stm.setInt(1, userId);
        int count = stm.executeUpdate();
        return count;
    }

    public int delete(int userId, String productId) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from cart where user_id=? and product_id=?");
        stm.setInt(1, userId);
        stm.setString(2, productId);
        int count = stm.executeUpdate();
        return count;
    }

    public int getQuantity(int userId, String productId) throws SQLException {
        int count = 0;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select quantity from cart where user_id=? and product_id=?");
        stm.setInt(1, userId);
        stm.setString(2, productId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            count = rs.getInt("quantity");
        }
        return count;
    }
}
