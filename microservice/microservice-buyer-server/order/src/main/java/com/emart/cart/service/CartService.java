package com.emart.cart.service;

import java.util.List;

import com.emart.cart.dao.CartDao;
import com.emart.cart.entity.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartDao cartDao;

    public Cart addCarts(Cart cart) {
        return this.cartDao.save(cart);
    }

    public Cart getCartByItemId(String item_id){
        return this.cartDao.findByItemId(item_id);
    }

    public List<Cart> listCarts(String buyerId) {
        return this.cartDao.findByBuyerId(buyerId);
    }

    public void deleteBatch(List<Long> LString) {
        cartDao.deleteBatch(LString);
    }

}
