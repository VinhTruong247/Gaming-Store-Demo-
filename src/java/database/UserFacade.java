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

/**
 *
 * @author VU HONG ANH
 */
public class UserFacade {

    public List<User> select() throws SQLException {
        List<User> list = null;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from users u inner join user_roles r on u.role_id=r.id");
        list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setRole(rs.getString("role"));
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_username"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setFullName(rs.getString("user_fullName"));
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
            queryCommand = "user_email=? and user_password=?";
        } else {
            queryCommand = "user_username=? and user_password=?";
        }
        PreparedStatement stm = con.prepareStatement("select * from users u inner join user_roles r on u.role_id=r.id where " + queryCommand);
        stm.setString(1, input);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setRole(rs.getString("role"));
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_username"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setFullName(rs.getString("user_fullName"));
        }
        con.close();
        return user;
    }

    //check tai khoan ton tai khong
    public int checkAccountExist(String input) throws SQLException, NoSuchAlgorithmException {
        int count = 0;
        User user = null;
        Connection con = Database.getConnection();
        String queryCommand = "";
        if (utils.Tools.verifyEmail(input)) {
            queryCommand = "user_email=?";
        } else {
            queryCommand = "user_username=?";
        }
        PreparedStatement stm = con.prepareStatement("select count(user_email) 'count' from users where " + queryCommand);
        stm.setString(1, input);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            count=rs.getInt("count");
        }
        con.close();
        System.out.println(count);
        return count;
    }

    public int getNextId(String role) throws SQLException{
        int count=0;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select max(user_id) 'max' from users group by role_id having role_id = ?");
        stm.setInt(1, getRoleId(role));
        ResultSet rs = stm.executeQuery();
        if(rs.next()) count=rs.getInt("max");
        con.close();
        return count+1;
    }
    
    public void create(User user) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("SET IDENTITY_INSERT users ON insert into users(role_id,user_id,user_username,user_email,user_password,user_fullName) values (?, ?, ?, ?, ?, ?) SET IDENTITY_INSERT users OFF");
        stm.setInt(1, getRoleId(user.getRole()));
        stm.setInt(2, user.getUserId());
        stm.setString(3, user.getUsername());
        stm.setString(4, user.getEmail());
        stm.setString(5, user.getPassword());
        stm.setString(6, user.getFullName());
        int count = stm.executeUpdate();
        con.close();
    }
    
    public void update(User user) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = Database.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update users set user_username = ?, user_email = ?, user_fullName = ? where user_id = ? and role_id = ?");
        //Thực thi lệnh sql
        stm.setString(1, user.getUsername());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getFullName());
        stm.setInt(4, user.getUserId());
        stm.setInt(5, getRoleId(user.getRole()));
        int count = stm.executeUpdate();        
        con.close();
    }
    
    public void changePass(User user) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = Database.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update users set user_password = ? where user_id = ? and role_id = ?");
        //Thực thi lệnh sql
        stm.setString(1, user.getPassword());
        stm.setInt(2, user.getUserId());
        stm.setInt(3, getRoleId(user.getRole()));
        int count = stm.executeUpdate();        
        con.close();
    }
    
    public int getRoleId(String role) throws SQLException{
        int id=0;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select id from user_roles where role=?");
        stm.setString(1, role);
        ResultSet rs = stm.executeQuery();
        if(rs.next()) id=rs.getInt("id");
        con.close();
        return id;
    }
}
