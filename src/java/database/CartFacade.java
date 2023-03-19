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
    
    public List<Product> select(String username) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select product_id from cart where username = ?");
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        List<Product> list = new ArrayList<>();
        ProductFacade pf = new ProductFacade();
        while(rs.next()){
            Product product = new Product();
            product = pf.read(rs.getString("product_id"));
            list.add(product);
        }
        return list;
    }
    
    public int add(String username, String productId) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into cart(username,product_id) values (?,?)");
        stm.setString(1, username);
        stm.setString(2, productId);
        int count = stm.executeUpdate();
        return count;
    }
    
    public int empty(String username) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from cart where username=?");
        stm.setString(1, username);
        int count = stm.executeUpdate();
        return count;
    }
    
    public int delete(String username, String productId) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from cart where username=? and product_id=?");
        stm.setString(1, username);
        stm.setString(2, productId);
        int count = stm.executeUpdate();
        return count;
    }
}