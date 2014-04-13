package org.datanucleus.samples.jdo.tutorial.daohelper.transaction;

/**
 * *****************************************************************************
 *                                                                             *
 *                                                                             *
 * Copyright (c) Telenity A.S. * All rights reserved. * * This document contains confidential and
 * proprietary information of Telenity * and any reproduction, disclosure, or use in whole or in
 * part is expressly * prohibited, except as may be specifically authorized by prior written *
 * agreement or permission of Telenity. * *
 * ****************************************************************************** * RESTRICTED
 * RIGHTS LEGEND * Use, duplication, or disclosure by Government Is Subject to restrictions as * set
 * forth in subparagraph (c)(1)(ii) of the Rights in Technical Data and * Computer Software clause
 * at DFARS 252.227-7013 * *
 *****************************************************************************
 */

/**
 * 
 * @author barise
 */
// TODO this enum has dao and historical.dao specific elements like CUSTOMER_USER_ID
// Think about making it more abstract
public enum DaoMethodArgumentTypes {
   PERSISTENCE_MANAGER(0),
   DATA_MODEL_ENTITY(1);

   private int id;

   private DaoMethodArgumentTypes(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

}
