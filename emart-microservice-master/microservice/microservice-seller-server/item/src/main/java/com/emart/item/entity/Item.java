package com.emart.item.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.emart.category.entity.Category;
import com.emart.subCategory.entity.SubCategory;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_item")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
// @AllArgsConstructor
public class Item  implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "itemId")
    private String itemId;
    
    @NotNull
    @Column(name = "item_name")
    private String item_name;
    
    @NotNull
    @Column(name = "sellerId")
    private String sellerId;

    @NotNull
    @Column(name = "categoryId")
    private String categoryId;

    @NotNull
    @Column(name = "subcategoryId")
    private String subcategoryId;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "stock_number")
    private int stock_number;

    @Column(name = "remarks")
    private String remarks;

    @CreatedDate
    @Column(name = "creat_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String creat_date;

}