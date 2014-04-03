package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.PersistenceCapable;

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
public class Product
{
    String name = null;
    String description = null;
    double price = 0.0;

    protected Product()
    {
    }

    public Product(String name, String desc, double price)
    {
        this.name = name;
        this.description = desc;
        this.price = price;
    }
}