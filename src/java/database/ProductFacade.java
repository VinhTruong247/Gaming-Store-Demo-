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

    public List<Product> searchProduct(String searchPhrase, String option) throws SQLException {
        List<Product> list = null;
        switch (option) {
            case "asc_name": {
                String query = "select * from products where product_name like ? order by product_name asc";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
            case "desc_name": {
                String query = "select * from products where product_name like ? order by product_name desc";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
            case "asc_category": {
                String query = "select * from products where product_name like ? order by product_category asc";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
            case "desc_category": {
                String query = "select * from products where product_name like ? order by product_category desc";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
            case "asc_price": {
                String query = "select * from products where product_name like ? order by price asc";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
            case "desc_price": {
                String query = "select * from products where product_name like ? order by price desc";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
            default: {
                String query = "select * from products where product_name like ?";
                Connection con = Database.getConnection();
                PreparedStatement pf = con.prepareStatement(query);
                pf.setString(1, "%" + searchPhrase + "%");
                ResultSet rs = pf.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductId(rs.getString("product_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPublisher(rs.getString("product_publisher"));
                    p.setCategory(rs.getString("product_category"));
                    p.setDescription(rs.getString("product_description"));
                    p.setQuantity(rs.getInt("quantity"));
                    p.setPrice(rs.getDouble("price"));
                    p.setProductImages(rs.getString("product_images"));
                    list.add(p);
                }
                con.close();
            }
            break;
        }
        return list;
    }

    public void addCart(String productId, int addQuantity, double price) throws SQLException {
        double totalPrice = addQuantity * price;
        Connection con = Database.getConnection();
        String query = "insert cart values (?, ?, ?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setString(1, productId);
        stm.setInt(2, addQuantity);
        stm.setDouble(3, totalPrice);
        ResultSet rs = stm.executeQuery();
        System.out.println("Addded " + addQuantity + "items of product " + productId + "to cart.");
        con.close();
    }

    public void addOrder() throws SQLException {
        Connection con = Database.getConnection();
        int orderId = countOrder() + 1;

    }

    public int countOrder() throws SQLException {
        int count = 0;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select count(distinct order_id) as Orders from orderlist");
        while (rs.next()) {
            count = rs.getInt("Orders");
        }
        return count;
    }

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
            p.setQuantity(rs.getInt("quantity"));
            p.setPrice(rs.getDouble("price"));
            p.setProductImages(rs.getString("product_images"));
            list.add(p);
        }
        con.close();
        return list;
    }

    public static List<Product> select() throws SQLException {
        List<Product> list = null;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from products");
        list = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getString("product_id"));
            p.setProductName(rs.getString("product_name"));
            p.setProductPublisher(rs.getString("product_publisher"));
            p.setCategory(rs.getString("product_category"));
            p.setDescription(rs.getString("product_description"));
            p.setQuantity(rs.getInt("quantity"));
            p.setPrice(rs.getDouble("price"));
            p.setProductImages(rs.getString("product_images"));
            list.add(p);
        }
        con.close();
        return list;
    }

    public void create(Product product) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert products values (?, ?, ?, ?, ?, ?, ?, ?)");
        stm.setString(1, product.getProductId());
        stm.setString(2, product.getProductName());
        stm.setString(3, product.getProductPublisher());
        stm.setString(4, product.getCategory());
        stm.setString(5, product.getDescription());
        stm.setDouble(6, product.getQuantity());
        stm.setDouble(7, product.getPrice());
        stm.setString(8, product.getProductImages());

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
        PreparedStatement stm = con.prepareStatement("update products set product_name = ?, product_publisher = ?, product_category = ?, product_description = ?, price = ?, quantity = ?, product_images = ? where product_id = ?");
        stm.setString(1, product.getProductName());
        stm.setString(2, product.getProductPublisher());
        stm.setString(3, product.getCategory());
        stm.setString(4, product.getDescription());
        stm.setDouble(5, product.getPrice());
        stm.setDouble(6, product.getQuantity());
        stm.setString(7, product.getProductImages());
        stm.setString(8, product.getProductId());
        int count = stm.executeUpdate();
        con.close();
    }

    public static Product read(String productId) throws SQLException {
        Product product = null;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from products where product_id = ?");
        stm.setString(1, productId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            product = new Product();
            product.setProductId(rs.getString("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPublisher(rs.getString("product_publisher"));
            product.setCategory(rs.getString("product_category"));
            product.setDescription(rs.getString("product_description"));
            product.setQuantity(rs.getInt("quantity"));
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

    public void saleCreate(Product product) throws SQLException {
        OrderListFacade olf = new OrderListFacade();
        int sold = olf.count(product.getProductId());
        double price = sold * product.getPrice();
        Connection con = Database.getConnection();
        System.out.println(sold);
        System.out.println(price);
        int count = 0;
        if (checkExist(product.getProductId())) {
            PreparedStatement stm = con.prepareStatement("update sale set sold_quantity = ?, price where product_id = ?");
            stm.setInt(1, sold);
            stm.setDouble(2, price);
            stm.setString(3, product.getProductId());
            count = stm.executeUpdate();
            System.out.println("update success");
        } else {
            PreparedStatement stm = con.prepareStatement("insert sale values(?, ?, ?)");
            stm.setString(1, product.getProductId());
            stm.setInt(2, sold);
            stm.setDouble(3, price);
            count = stm.executeUpdate();
        }
            System.out.println(count);
            con.close();
    }

    public static List<Product> saleSelect() throws SQLException {
        List<Product> list = null;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from sale");
        list = new ArrayList<>();
        while (rs.next()) {
            String p = rs.getString("product_id");
            Product product = read(p);
            list.add(product);
        }
        con.close();
        return list;
    }

    public boolean checkExist(String productId) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select product_id from sale where product_id = ?");
        stm.setString(1, productId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            return true;
        }
        con.close();
        return false;
    }
}
