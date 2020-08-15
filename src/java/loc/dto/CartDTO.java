/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TungLoc
 */
public class CartDTO implements Serializable {

    private Map<String, BookDTO> cart;

    public CartDTO() {
    }

    /**
     * @return the cart
     */
    public Map<String, BookDTO> getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }
    
    public void add(BookDTO dto) {
        if (this.cart == null){
            cart = new HashMap<>();
        }
        
        if (this.cart.containsKey(dto.getBookID())){
            int quantity = cart.get(dto.getBookID()).getQuantity();
            dto.setQuantity(quantity + 1);
        }
        
        cart.put(dto.getBookID(), dto);
    }
    
    public void delete(String id) {
        if (this.cart == null) {
            return;
        }

        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(String id, BookDTO dto) {
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.replace(id, dto);
            }
        }
    }
}
