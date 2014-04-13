/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial.dao;

import javax.jdo.PersistenceManager;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.DaoMethodArgumentTypes;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.MarkMethodArgument;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.Transactional;
import org.datanucleus.samples.jdo.tutorial.model.Book;

/**
 *
 * @author bergun
 */
public class JdoTutorialDaoDelegator {

    @Transactional
    public Book createBook(@MarkMethodArgument(methodParamType = DaoMethodArgumentTypes.PERSISTENCE_MANAGER) PersistenceManager pm, Book bookToCreate) {
        return pm.makePersistent(bookToCreate);
    }

}
