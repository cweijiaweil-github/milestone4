package com.emart.category.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.emart.category.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CategoryDao  extends JpaRepository<Category, Integer>{
    
@Query(value = "select * from t_category as t where t.seller_id = ?1", nativeQuery = true)
List<Category> findAllBySellerId(String sellerId);

}