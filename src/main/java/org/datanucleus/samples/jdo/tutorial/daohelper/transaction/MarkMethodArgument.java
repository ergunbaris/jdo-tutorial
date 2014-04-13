/*******************************************************************************
 *                                                                             *
 *                                                                             *
 * Copyright (c) Telenity A.S.                                                 *
 * All rights reserved.                                                        *
 *                                                                             *
 * This document contains confidential and proprietary information of Telenity *
 * and any reproduction, disclosure, or use in whole or in part is expressly   *
 * prohibited, except as may be specifically authorized by prior written       *
 * agreement or permission of Telenity.                                        *
 *                                                                             *
 *******************************************************************************
 *                                                                             *
 *                     RESTRICTED RIGHTS LEGEND                                *
 * Use, duplication, or disclosure by Government Is Subject to restrictions as *
 * set forth in subparagraph (c)(1)(ii) of the Rights in Technical Data and    *
 * Computer Software clause at DFARS 252.227-7013                              *
 *                                                                             *
 ******************************************************************************/

package org.datanucleus.samples.jdo.tutorial.daohelper.transaction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author barise
 * @date Feb 11, 2014
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MarkMethodArgument {

   public DaoMethodArgumentTypes methodParamType();

}
