/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import loc.dto.BookDTO;
import loc.dto.OrderDTO;
import loc.utils.DBUtils;

/**
 *
 * @author TungLoc
 */
public class OrderDAO implements Serializable{
    public boolean insertOrder(OrderDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "insert tblOrders(OrderID, UserID, GetDate, ReturnDate, Total) values(?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getOrderID());
                pst.setString(2, dto.getUserID());
                pst.setDate(3, dto.getGetDate());
                pst.setDate(4, dto.getReturnDate());
                pst.setDouble(5, dto.getTotal());
                int row = pst.executeUpdate();
                if (row > 0){
                    return true;
                }
            }
        } finally {
            
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean checkoutOrder(String id, Map<String, BookDTO> cart) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null){
                int row = 0;
                String sql = "insert tblOrderDetais(OrderID, BookID, Quantity, Price) values(?,?,?,?)";
                for (String items : cart.keySet()) {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, id);
                    pst.setString(2, items);
                    pst.setInt(3, cart.get(items).getQuantity());
                    pst.setDouble(4, cart.get(items).getPrice());
                    row = pst.executeUpdate();
                }
                if (row > 0){
                    return true;
                }
            }
        } finally {
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
}
