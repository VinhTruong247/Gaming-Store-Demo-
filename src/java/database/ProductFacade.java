/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VU HONG ANH
 */
public class ProductFacade {

    public List<Product> select() throws SQLException {
        List<Product> list = null;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from products");
        list = new ArrayList<>();
        while(rs.next()){
            Product p = new Product();
            p.setProductId(rs.getString("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductPublisher(rs.getString("product_publisher"));
            p.setCategory(rs.getString("product_category"));
            p.setDescription(rs.getString("product_description"));
            p.setPrice(rs.getDouble("price"));
            list.add(p);
        }
        con.close();
        return list;
    }
}
