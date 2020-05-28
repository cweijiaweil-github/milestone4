package com.emart.item.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.emart.item.entity.Item;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {

    @Transactional
    @Modifying
    @Query(value = "select i.item_name,c.category_name,s.sub_category_id,s.sub_category_name from t_item as i,t_category as c,t_sub_category as s where i.category_id = c.category_id and i.category_id = s.category_id and i.seller_id = ?1", nativeQuery = true)
    List<Map<String, Object>> findItemList(String sellerId);

    @Modifying
    @Transactional
    @Query(value = "delete from t_item as t where t.item_id = ?1", nativeQuery = true)
    public int deleteByItemId(String itemId);

    @Query(value = "select i.item_name,i.price,i.description,i.seller_id,c.category_name,c.category_id,s.sub_category_id,s.sub_category_name from t_item as i,t_category as c,t_sub_category as s where i.item_name like %?1% and i.category_id = c.category_id and i.subcategory_id = s.sub_category_id", nativeQuery = true)
    public List<Map<String, Object>> findAllByItemName(String item_name);
    
    @Query(value = "select i.item_name,i.price,i.description,i.seller_id,c.category_name,c.category_id,s.sub_category_id,s.sub_category_name from t_item as i,t_category as c,t_sub_category as s where i.category_id = c.category_id and i.subcategory_id = s.sub_category_id", nativeQuery = true)
    public List<Map<String,Object>> findAllItems();

    @Query(value = "select i.item_name,i.price,i.description,i.seller_id,c.category_name,c.category_id,s.sub_category_id,s.sub_category_name from t_item as i,t_category as c,t_sub_category as s where i.price between ?1 and ?2 and i.category_id = c.category_id and i.subcategory_id = s.sub_category_id", nativeQuery = true)
    public List<Map<String, Object>> findByPriceBetween(Double priceStart, Double priceEnd);

    public Item findByItemId(String itemId);

}