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
public class UserFacade {
    public List<User> select() throws SQLException {
        List<User> list = null;
        Connection con = Database.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from users");
        list = new ArrayList<>();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_userName"));
            user.setPassword(rs.getString("user_password"));
            user.setEmail(rs.getString("user_email"));
            user.setFullName(rs.getString("user_fullName"));
            user.setRole(rs.getString("user_role"));
            list.add(user);
        }
        con.close();
        return list;
    }
}
