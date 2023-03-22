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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author binla
 */
public class OrderListFacade {
    public int add(Item item,int userId,Date issueDate) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into orderList values (?,?,?,?)");
        stm.setString(1, item.getProduct().getProductId());
        stm.setInt(2, userId);
        stm.setDouble(3, item.getTotal());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(issueDate));
        int count = stm.executeUpdate();
        return count;
    }
    
}
