/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial.model;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author bergun
 */
//@PersistenceCapable
public class Inventory {

    @PrimaryKey
    @Column(name = "INVENTORY_NAME", allowsNull = "false", jdbcType = "VARCHAR", length = 100)
    private String name = null;
    
    @Persistent(table="INVENTORY_PRODUCT_RELATION")
    @Join(column="INVENTORY_NAME")
    @Element(column="BOOK_NAME")
    private Set<Product> products = new HashSet<>();

    public Inventory(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

}
