/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.datanucleus.samples.jdo.tutorial.dao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javax.jdo.PersistenceManagerFactory;
import org.datanucleus.samples.jdo.tutorial.guice.JdoTutorialModule;
import org.datanucleus.samples.jdo.tutorial.model.Book;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bergun
 */
public class JdoTutorialDaoTest {

    private JdoTutorialDao daoUnderTest;

    private PersistenceManagerFactory pmfUnderTest;

    public JdoTutorialDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        JdoTutorialModule module = new JdoTutorialModule();
        Injector injector = Guice.createInjector(module);
        daoUnderTest = injector.getInstance(JdoTutorialDao.class);
        pmfUnderTest = injector.getInstance(PersistenceManagerFactory.class);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {

        pmfUnderTest.close();
        daoUnderTest = null;
    }

    public final static String BOOK_NAME = "Kaşağı";

    public final static String BOOK_DESC = "Kaşağı";

    public final static double BOOK_PRICE = 10.0;

    public final static String AUTHOR_NAME = "Ömer Seyfettin";

    public final static String ISBN = "345345345";

    public final static String PUBLISHER_NAME = "Dost Yayınevi";

    @Test
    public void shouldCreateABook() {
        Book newBook = new Book(BOOK_NAME, BOOK_DESC, BOOK_PRICE, AUTHOR_NAME, ISBN, PUBLISHER_NAME);
        Book createdBook = daoUnderTest.createBook(newBook);
        Assert.assertTrue(createdBook.getId() > 0);

    }

}
