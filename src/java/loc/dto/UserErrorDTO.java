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
public class UserErrorDTO implements Serializable{
    private String userIDError;
    private String fullnameError;
    private String addressError;
    private String phoneError;
    private String passwordError;
    private String rePasswordError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String fullnameError, String addressError, String phoneError, String passwordError, String rePasswordError) {
        this.userIDError = userIDError;
        this.fullnameError = fullnameError;
        this.addressError = addressError;
        this.phoneError = phoneError;
        this.passwordError = passwordError;
        this.rePasswordError = rePasswordError;
    }

    /**
     * @return the userIDError
     */
    public String getUserIDError() {
        return userIDError;
    }

    /**
     * @param userIDError the userIDError to set
     */
    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    /**
     * @return the fullnameError
     */
    public String getFullnameError() {
        return fullnameError;
    }

    /**
     * @param fullnameError the fullnameError to set
     */
    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    /**
     * @return the addressError
     */
    public String getAddressError() {
        return addressError;
    }

    /**
     * @param addressError the addressError to set
     */
    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    /**
     * @return the phoneError
     */
    public String getPhoneError() {
        return phoneError;
    }

    /**
     * @param phoneError the phoneError to set
     */
    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    /**
     * @return the passwordError
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * @param passwordError the passwordError to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * @return the rePasswordError
     */
    public String getRePasswordError() {
        return rePasswordError;
    }

    /**
     * @param rePasswordError the rePasswordError to set
     */
    public void setRePasswordError(String rePasswordError) {
        this.rePasswordError = rePasswordError;
    }
    
}
