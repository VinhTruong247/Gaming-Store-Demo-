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
        while(rs.next()){
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
    public User loginEmail(String email, String password) throws SQLException, NoSuchAlgorithmException{
        User user = null;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from users u inner join user_roles r on u.role_id=r.id where user_email=? and user_password=?");
        stm.setString(1, email);
        stm.setString(2, Hasher.hash(password));
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
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
    //login bang email
    public User loginUsername(String username, String password) throws SQLException, NoSuchAlgorithmException{
        User user = null;
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from users u inner join user_roles r on u.role_id=r.id where user_username=? and user_password=?");
        stm.setString(1, username);
        stm.setString(2, Hasher.hash(password));
        ResultSet rs = stm.executeQuery();
        if(rs.next()){
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
}
