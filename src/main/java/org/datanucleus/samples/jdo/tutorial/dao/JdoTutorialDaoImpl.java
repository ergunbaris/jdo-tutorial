/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial.dao;

import com.google.inject.Inject;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import org.datanucleus.samples.jdo.tutorial.model.Book;

/**
 *
 * @author bergun
 */
public class JdoTutorialDaoImpl implements JdoTutorialDao {

    private final PersistenceManagerFactory pmf;

    @Inject
    public JdoTutorialDaoImpl(PersistenceManagerFactory pmf) {
        this.pmf = pmf;
    }

    @Inject
    private JdoTutorialDaoDelegator delegator;

    @Override
    public PersistenceManagerFactory getPersistenceManagerFactory() {
        return pmf;
    }

    @Override
    public Book createBook(Book bookToCreate) {
        PersistenceManager pm = pmf.getPersistenceManager();
        return delegator.createBook(pm, bookToCreate);
    }

}
