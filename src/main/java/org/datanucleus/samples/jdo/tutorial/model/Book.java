/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial.model;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 *
 * @author bergun
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Book extends Product {

    @Persistent
    @Column(name = "AUTHOR", allowsNull = "false", jdbcType = "VARCHAR", length = 40)
    String author = null;
    @Persistent
    @Column(name = "ISBN", allowsNull = "false", jdbcType = "VARCHAR", length = 20)
    String isbn = null;
    @Persistent
    @Column(name = "PUBLISHER", allowsNull = "false", jdbcType = "VARCHAR", length = 20)
    String publisher = null;

    public Book(String name, String desc, double price, String author,
            String isbn, String publisher) {
        super(name, desc, price);
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
