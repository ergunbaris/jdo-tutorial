/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import org.datanucleus.samples.jdo.tutorial.dao.JdoTutorialDao;
import org.datanucleus.samples.jdo.tutorial.dao.JdoTutorialDaoDelegator;
import org.datanucleus.samples.jdo.tutorial.dao.JdoTutorialDaoImpl;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.NonTransactional;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.NonTransactionalInterceptor;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.Transactional;
import org.datanucleus.samples.jdo.tutorial.daohelper.transaction.TransactionalInterceptor;

/**
 *
 * @author bergun
 */
public class JdoTutorialModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(JdoTutorialDao.class).to(JdoTutorialDaoImpl.class);
        bind(JdoTutorialDaoDelegator.class);

        bindInterceptor(
                Matchers.any(), Matchers.annotatedWith(Transactional.class),
                new TransactionalInterceptor());
        bindInterceptor(
                Matchers.any(), Matchers.annotatedWith(NonTransactional.class),
                new NonTransactionalInterceptor());
    }

    @Provides
    @Singleton
    public PersistenceManagerFactory getPersistenceManagerFactory() {

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("JDO_TUTORIAL");

        return pmf;
    }
}
