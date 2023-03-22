/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import utils.Tools;

/**
 *
 * @author VU HONG ANH
 */
public class UserFacade {

    public List<User> select() throws SQLException, NoSuchAlgorithmException {
        List<User> list = null;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from users");
        list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setRole(getRole(rs.getInt("role_id")));
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_username"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setFullName(rs.getString("user_fullName"));
            user.setAddress(rs.getString("user_address"));
            user.setActive(rs.getBoolean("user_active"));
            list.add(user);
        }
        con.close();
        return list;
    }

    //login bang email
    public User login(String input, String password) throws SQLException, NoSuchAlgorithmException {
        User user = null;
        Connection con = Database.getConnection();
        String queryCommand = "";
        if (utils.Tools.verifyEmail(input)) {
            queryCommand = "user_email=?";
        } else {
            queryCommand = "user_username=?";
        }
        PreparedStatement stm = con.prepareStatement("select * from users where " + queryCommand + " and user_password=?");
        stm.setString(1, input);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setRole(getRole(rs.getInt("role_id")));
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_username"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setFullName(rs.getString("user_fullName"));
            user.setAddress(rs.getString("user_address"));
            user.setActive(rs.getBoolean("user_active"));
        }
        con.close();
        return user;
    }

    //check tai khoan ton tai khong
    public User getUser(String input) throws SQLException, NoSuchAlgorithmException {
        User user = null;
        Connection con = Database.getConnection();
        String queryCommand = "";
        if (utils.Tools.verifyEmail(input)) {
            queryCommand = "user_email=?";
        } else {
            queryCommand = "user_username=?";
        }
        PreparedStatement stm = con.prepareStatement("select * from users where " + queryCommand);
        stm.setString(1, input);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setRole(getRole(rs.getInt("role_id")));
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_username"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setFullName(rs.getString("user_fullName"));
            user.setAddress(rs.getString("user_address"));
            user.setActive(rs.getBoolean("user_active"));
        }
        con.close();
        return user;
    }

    public int create(int roleId, String username, String email, String password, String fullName, String address) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into users(role_id,user_username,user_email,user_password,user_fullName,user_address,user_active) values (?, ?, ?, ?, ?, ?, ?)");
        stm.setInt(1, roleId);
        stm.setString(2, username);
        stm.setString(3, email);
        stm.setString(4, password);
        stm.setString(5, fullName);
        stm.setString(6, address);
        stm.setBoolean(7, true);
        int count = stm.executeUpdate();
        con.close();
        return count;
    }

    public void update(User user) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = Database.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update users set user_username = ?, user_email = ?, user_fullName = ?, user_address = ? where user_id = ?");
        //Thực thi lệnh sql
        stm.setString(1, user.getUsername());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getFullName());
        stm.setString(4, user.getAddress());
        stm.setInt(5, user.getUserId());
        int count = stm.executeUpdate();
        con.close();
    }

    public void changePass(User user) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = Database.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update users set user_password = ? where user_id = ?");
        //Thực thi lệnh sql
        stm.setString(1, user.getPassword());
        stm.setInt(2, user.getUserId());
        int count = stm.executeUpdate();
        con.close();
    }

    public String getRole(int roleId) throws SQLException, NoSuchAlgorithmException {
        User user = null;
        Connection con = Database.getConnection();
        String role = "";
        PreparedStatement stm = con.prepareStatement("select role from user_roles where id = ?");
        stm.setInt(1, roleId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            role = rs.getString("role");
        }
        con.close();
        return role;
    }

    public int promote(int userId) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = Database.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update users set role_id=1 where user_id = ?");
        //Thực thi lệnh sql
        stm.setInt(1, userId);
        int count = stm.executeUpdate();
        con.close();
        return count;
    }

    public int deactivate(int userId) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = Database.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update users set user_active=0 where user_id = ?");
        //Thực thi lệnh sql
        stm.setInt(1, userId);
        int count = stm.executeUpdate();
        con.close();
        return count;
    }

    public List<User> search(String input) throws SQLException, NoSuchAlgorithmException {
        List<User> list = null;
        String query = "select * from users where ";
        if (!input.isEmpty()) {
            if (Tools.verifyEmail(input)) {
                query += "user_email like '%" + input + "%'";
            }
            else if (input.equalsIgnoreCase("ADMIN")) {
                query += "role_id = 1";
            }
            else if (input.equalsIgnoreCase("CUSTOMER")) {
                query += "role_id =2";
            }
            else if (input.matches("[0-9]*")) {
                query += "user_id like '%" + input + "%'";
            }
            else{
                query += "user_username like '%" + input + "%'";
                query += " or user_fullName like '%" + input + "%'";
                query += " or user_address like '%" + input + "%'";
                
            }
        }
        else{
            query += "user_username is not null";
        }
        System.out.println(query);  
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setRole(getRole(rs.getInt("role_id")));
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_username"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setFullName(rs.getString("user_fullName"));
            user.setAddress(rs.getString("user_address"));
            user.setActive(rs.getBoolean("user_active"));
            list.add(user);
        }
        con.close();
        return list;
    }
}
