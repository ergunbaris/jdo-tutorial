package org.datanucleus.samples.jdo.tutorial.model;

import java.util.Set;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bergun
 */
@PersistenceCapable
public class Product {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    long id;

    @Persistent
    @Column(name = "PRODUCT_NAME", allowsNull = "false", jdbcType = "VARCHAR", length = 100)
    String name = null;

    @Persistent
    @Column(name = "DESCRIPTION", allowsNull = "true", jdbcType = "VARCHAR", length = 255)
    String description = null;
    double price = 0.0;
    
//    @Persistent(mappedBy="products")
//    Set<Inventory> inventories;

    protected Product() {
    }

    public Product(String name, String desc, double price) {
        this.name = name;
        this.description = desc;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
