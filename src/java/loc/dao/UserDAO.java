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
import javax.naming.NamingException;
import loc.dto.UserDTO;
import loc.utils.DBUtils;

/**
 *
 * @author TungLoc
 */
public class UserDAO implements Serializable {

    public UserDTO checkLogin(String userID, String password) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UserDTO dto = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "select Fullname, Address, Phone, RoleName from tblUsers u join tblRole r on u.RoleID = r.RoleID where u.UserID = ? and Password = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()){
                    String fullname = rs.getString("Fullname");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    String role = rs.getString("RoleName");
                    dto = new UserDTO(userID, password, fullname, address, phone, role);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }
    
    public boolean createAccount(UserDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "insert tblUsers(UserID, Password, Fullname, Address, Phone, RoleID) values(?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getUserID());
                pst.setString(2, dto.getPassword());
                pst.setString(3, dto.getFullname());
                pst.setString(4, dto.getAddress());
                pst.setString(5, dto.getPhone());
                pst.setString(6, dto.getRole());
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
}
