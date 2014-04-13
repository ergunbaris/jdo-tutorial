/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.datanucleus.samples.jdo.tutorial.dao;

import javax.jdo.PersistenceManagerFactory;
import org.datanucleus.samples.jdo.tutorial.model.Book;

/**
 *
 * @author bergun
 */
public interface JdoTutorialDao {
    
    public PersistenceManagerFactory getPersistenceManagerFactory();
    
    public Book createBook (Book bookToCreate);
}
