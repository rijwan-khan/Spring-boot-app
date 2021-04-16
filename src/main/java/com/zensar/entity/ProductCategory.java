package com.zensar.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="product_category")
@Data
public class ProductCategory {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> products;

}