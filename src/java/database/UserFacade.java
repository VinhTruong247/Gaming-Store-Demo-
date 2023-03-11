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
import utils.Hasher;

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
        stm.setString(2, Hasher.hash(password));
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
    public boolean checkAccountExist(String input) throws SQLException, NoSuchAlgorithmException {
        User user = null;
        Connection con = Database.getConnection();
        String queryCommand = "";
        if (utils.Tools.verifyEmail(input)) {
            queryCommand = "user_email=?";
        } else {
            queryCommand = "user_username=?";
        }
        PreparedStatement stm = con.prepareStatement("select * from users u where " + queryCommand);
        stm.setString(1, input);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            return true;
        }
        con.close();
        return false;
    }

    public int getNextId(String role) throws SQLException{
        int count=0;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select max(user_id) 'max' from users group by role_id having role_id = ?");
        stm.setInt(1, (role.matches("ADMIN")? 1: 2));
        ResultSet rs = stm.executeQuery();
        if(rs.next()) count=rs.getInt("max");
        con.close();
        return count+1;
    }
    
    public void create(User user) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("SET IDENTITY_INSERT users ON insert into users(role_id,user_id,user_username,user_email,user_password,user_fullName) values (?, ?, ?, ?, ?, ?) SET IDENTITY_INSERT users OFF");
        stm.setInt(1, (user.getRole().matches("ADMIN")? 1 : 2));
        stm.setString(2, user.getUserId().substring(user.getUserId().lastIndexOf("-")+1));
        stm.setString(3, user.getUsername());
        stm.setString(4, user.getEmail());
        stm.setString(6, user.getPassword());
        stm.setString(5, user.getFullName());
        int count = stm.executeUpdate();
        con.close();
    }
}
