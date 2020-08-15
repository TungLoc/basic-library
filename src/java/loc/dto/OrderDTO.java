/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author TungLoc
 */
public class OrderDTO implements Serializable {

    private String orderID;
    private String userID;
    private Date getDate;
    private Date returnDate;
    private double total;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, Date getDate, Date returnDate, double total) {
        this.orderID = orderID;
        this.userID = userID;
        this.getDate = getDate;
        this.returnDate = returnDate;
        this.total = total;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the getDate
     */
    public Date getGetDate() {
        return getDate;
    }

    /**
     * @param getDate the getDate to set
     */
    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
