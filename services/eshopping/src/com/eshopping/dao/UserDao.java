/**
 * Copyright (C) 2015 WaveMaker, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eshopping.dao;
// Generated 28 Nov, 2014 11:40:08 AM 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.eshopping.*;
/**
 * Specifies methods used to obtain and modify User related information
 * which is stored in the database.
 */
@Repository("eshopping.UserDao")
public class UserDao extends WMGenericDaoImpl <User, Integer> {

   @Autowired
   @Qualifier("eshoppingTemplate")
   private HibernateTemplate template;

   public HibernateTemplate getTemplate() {
        return this.template;
   }
}

