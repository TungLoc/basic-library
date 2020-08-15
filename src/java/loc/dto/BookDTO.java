/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dto;

import java.io.Serializable;

/**
 *
 * @author TungLoc
 */
public class BookDTO implements Serializable{
    private String bookID;
    private String bookname;
    private int quantity;
    private double price;
    private String author;
    private boolean status;
    private String url;

    public BookDTO() {
    }

    public BookDTO(String bookID, String bookname, int quantity, double price, String author, boolean status, String url) {
        this.bookID = bookID;
        this.bookname = bookname;
        this.quantity = quantity;
        this.price = price;
        this.author = author;
        this.status = status;
        this.url = url;
    }
    
    public BookDTO(String bookID, String bookname, int quantity, double price, String author, String url) {
        this.bookID = bookID;
        this.bookname = bookname;
        this.quantity = quantity;
        this.price = price;
        this.author = author;
        this.url = url;
    }

    /**
     * @return the bookID
     */
    public String getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the bookname
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * @param bookname the bookname to set
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
}
