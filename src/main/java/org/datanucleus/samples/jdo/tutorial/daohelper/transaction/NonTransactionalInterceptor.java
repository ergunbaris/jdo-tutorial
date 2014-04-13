/**
 * *****************************************************************************
 *                                                                             *
 *                                                                             *
 * Copyright (c) Telenity A.S. * All rights reserved. * * This document contains
 * confidential and proprietary information of Telenity * and any reproduction,
 * disclosure, or use in whole or in part is expressly * prohibited, except as
 * may be specifically authorized by prior written * agreement or permission of
 * Telenity. * *
 * ******************************************************************************
 * * RESTRICTED RIGHTS LEGEND * Use, duplication, or disclosure by Government Is
 * Subject to restrictions as * set forth in subparagraph (c)(1)(ii) of the
 * Rights in Technical Data and * Computer Software clause at DFARS 252.227-7013
 * * *
 * ****************************************************************************
 */
package org.datanucleus.samples.jdo.tutorial.daohelper.transaction;

import java.lang.annotation.Annotation;
import java.util.Collection;
import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.datanucleus.samples.jdo.tutorial.dao.JdoTutorialDaoException;

/**
 *
 * @author barise
 * @date Feb 10, 2014
 */
// TODO this interceptor has dao and historical.dao specific elements like CUSTOMER_USER_ID
// Think about making it more abstract
public class NonTransactionalInterceptor implements MethodInterceptor {

    static final org.slf4j.Logger logger = org.slf4j.LoggerFactory
            .getLogger(NonTransactionalInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        logger.trace("Dao method {} being intercepted", methodInvocation.getMethod().getName());
        PersistenceManager pm = null;
        Annotation[][] annotationArray = methodInvocation.getMethod().getParameterAnnotations();
        int i = 0;
        for (Annotation[] annotationsOfParameter : annotationArray) {

            for (Annotation annotationOfParameter : annotationsOfParameter) {
                if (annotationOfParameter instanceof MarkMethodArgument) {
                    MarkMethodArgument argumentAnnotation = (MarkMethodArgument) annotationOfParameter;

                    switch (argumentAnnotation.methodParamType()) {
                        case PERSISTENCE_MANAGER:
                            pm = (PersistenceManager) methodInvocation.getArguments()[i];
                            break;

                    }
                }
            }
            i++;
        }
        if (null == pm) {
            throw new NullPointerException("Persistence Manager cannot be null");
        }
        Object result = null;

        try {
            result = methodInvocation.proceed();

        } catch (javax.jdo.JDOObjectNotFoundException e) {
            logger.info("JDOObjectNotFoundException: {}", e);
            throw e;
        } catch (JdoTutorialDaoException e) {
            throw e;
        } catch (Exception e) {
            logger.info("Exception: {}", e);
            throw new JDOException("Exception", e);
        } finally {
            pm.close();
        }

        if (result instanceof Collection) {
            logger.trace("Exiting Dao method {} with result size= {}", methodInvocation.getMethod()
                    .getName(), ((Collection) result).size());
        } else {
            logger.trace("Exiting Dao method {} with result = {}", methodInvocation.getMethod()
                    .getName(), result);
        }

        return result;

    }

}
