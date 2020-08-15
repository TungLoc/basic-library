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
public class BookErrorDTO implements Serializable{
    private String bookIDError;
    private String bookNameError;
    private String authorError;
    private String quantityError;
    private String priceError;

    public BookErrorDTO() {
    }

    public BookErrorDTO(String bookIDError, String bookNameError, String authorError, String quantityError, String priceError) {
        this.bookIDError = bookIDError;
        this.bookNameError = bookNameError;
        this.authorError = authorError;
        this.quantityError = quantityError;
        this.priceError = priceError;
    }

    /**
     * @return the bookIDError
     */
    public String getBookIDError() {
        return bookIDError;
    }

    /**
     * @param bookIDError the bookIDError to set
     */
    public void setBookIDError(String bookIDError) {
        this.bookIDError = bookIDError;
    }

    /**
     * @return the bookNameError
     */
    public String getBookNameError() {
        return bookNameError;
    }

    /**
     * @param bookNameError the bookNameError to set
     */
    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    /**
     * @return the authorError
     */
    public String getAuthorError() {
        return authorError;
    }

    /**
     * @param authorError the authorError to set
     */
    public void setAuthorError(String authorError) {
        this.authorError = authorError;
    }

    /**
     * @return the quantityError
     */
    public String getQuantityError() {
        return quantityError;
    }

    /**
     * @param quantityError the quantityError to set
     */
    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    /**
     * @return the priceError
     */
    public String getPriceError() {
        return priceError;
    }

    /**
     * @param priceError the priceError to set
     */
    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }
    
}
