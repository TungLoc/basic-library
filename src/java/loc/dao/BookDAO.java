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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import loc.dto.BookDTO;
import loc.utils.DBUtils;

/**
 *
 * @author TungLoc
 */
public class BookDAO implements Serializable{
    public List<BookDTO> getListBook(String seach) throws SQLException, NamingException{
        List<BookDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "select BookID, Bookname, Quantity, Price, Author, Status, url from tblBooks where Bookname like ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + seach +"%");
                rs = pst.executeQuery();
                while (rs.next()){
                    String bookID = rs.getString("BookID");
                    String bookname = rs.getString("Bookname");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String author = rs.getString("Author");
                    boolean status = rs.getBoolean("Status");
                    String url = rs.getString("url");
                    list.add(new BookDTO(bookID, bookname, quantity, price, author, status, url));
                }
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return list;
    }
    
    public List<BookDTO> getListBookForUser(String seach) throws SQLException, NamingException{
        List<BookDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "select BookID, Bookname, Quantity, Price, Author, url from tblBooks where Bookname like ? and (Price > 0 or Status = 1)";
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + seach +"%");
                rs = pst.executeQuery();
                while (rs.next()){
                    String bookID = rs.getString("BookID");
                    String bookname = rs.getString("Bookname");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String author = rs.getString("Author");
                    String url = rs.getString("url");
                    list.add(new BookDTO(bookID,bookname, quantity, price, author, url));
                }
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return list;
    }
    
    public BookDTO getBook(String seach) throws SQLException, NamingException{
        BookDTO dto = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "select BookID, Bookname, Quantity, Price, Author, url from tblBooks where BookID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, seach);
                rs = pst.executeQuery();
                while (rs.next()){
                    String bookID = rs.getString("BookID");
                    String bookname = rs.getString("Bookname");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    String author = rs.getString("Author");
                    String url = rs.getString("url");
                    dto = new BookDTO(bookID, bookname, quantity, price, author, url);
                }
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return dto;
    }
    
    public boolean deleteBook(String bookID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "update tblBooks set Status = 0 where BookID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, bookID);
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
    
    public boolean updateBook(BookDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "update tblBooks set Bookname = ?, Quantity = ?, Price = ?, Author = ?, Status = ?, url = ? where BookID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getBookname());
                pst.setInt(2, dto.getQuantity());
                pst.setDouble(3, dto.getPrice());
                pst.setString(4, dto.getAuthor());
                pst.setBoolean(5, dto.isStatus());
                pst.setString(6, dto.getUrl());
                pst.setString(7, dto.getBookID());
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
    
    public boolean insertBook(BookDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "insert tblBooks(BookID,Bookname,Quantity,Price,Author,Status,url) values (?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getBookID());
                pst.setString(2, dto.getBookname());
                pst.setInt(3, dto.getQuantity());
                pst.setDouble(4, dto.getPrice());
                pst.setString(5, dto.getAuthor());
                pst.setBoolean(6, dto.isStatus());
                pst.setString(7, dto.getUrl());
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
    
    public boolean updateQuantity(int quantity, String bookID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "update tblBooks set Quantity = ? where BookID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, quantity);
                pst.setString(2, bookID);
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
    
    public int checkQuantity(String bookID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int quantity = -1;
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "select Quantity from tblBooks where BookID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, bookID);
                rs = pst.executeQuery();
                if (rs.next()){
                    quantity = rs.getInt("Quantity");
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
        return quantity;
    }
}
