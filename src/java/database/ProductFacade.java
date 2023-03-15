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
public class ProductFacade {

        public List<Product> selectPerPage(int pageNum) throws SQLException {
        List<Product> list = null;
        String query = "select * from products order by product_name offset ? rows fetch first 6 rows only";
        Connection con = Database.getConnection();
        PreparedStatement pf = con.prepareStatement(query);
        pf.setInt(1, (pageNum - 1) * 6);
        ResultSet rs = pf.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getString("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductPublisher(rs.getString("product_publisher"));
            p.setCategory(rs.getString("product_category"));
            p.setDescription(rs.getString("product_description"));
            p.setPrice(rs.getDouble("price"));
            p.setProductImages(rs.getString("product_images"));
            list.add(p);
        }
        con.close();
        return list;
    }

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
            p.setProductImages(rs.getString("product_images"));
            list.add(p);
        }
        con.close();
        return list;
    }
    
    public void create(Product product) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert products values (?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, product.getProductId());
        stm.setString(2, product.getProductName());
        stm.setString(3, product.getProductPublisher());
        stm.setString(4, product.getCategory());
        stm.setString(5, product.getDescription());
        stm.setDouble(6, product.getPrice());
        stm.setString(7, product.getProductImages());
        
        int count = stm.executeUpdate();
        con.close();
    }
    
    public void delete(String productId) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from products where product_id = ?");
        stm.setString(1, productId);
        int count = stm.executeUpdate();
        con.close();
    }
    
    public void update(Product product) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("update products set product_name = ?, product_publisher = ?, product_category = ?, product_description = ?, price = ? where product_id = ?");
        stm.setString(1, product.getProductName());
        stm.setString(2, product.getProductPublisher());
        stm.setString(3, product.getCategory());
        stm.setString(4, product.getDescription());
        stm.setDouble(5, product.getPrice());
        stm.setString(6, product.getProductId());
        int count = stm.executeUpdate();
        con.close();
    }
    
    public Product read(String productId) throws SQLException {
        Product product = null;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from products where product_id = ?");
        stm.setString(1, productId);
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            product = new Product();
            product.setProductId(rs.getString("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPublisher(rs.getString("product_publisher"));
            product.setCategory(rs.getString("product_category"));
            product.setDescription(rs.getString("product_description"));
            product.setPrice(rs.getDouble("price"));
            product.setProductImages(rs.getString("product_images"));
        }
        con.close();
        return product;
    }
    
    public int countProduct() throws SQLException {
        int count = 0;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select count(product_id) as Quantity from products");
        while (rs.next()) {
            count = rs.getInt("Quantity");
        }
        con.close();
        return count;
    }
}
