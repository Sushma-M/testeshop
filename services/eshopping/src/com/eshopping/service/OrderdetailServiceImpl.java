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
package com.eshopping.service;
// Generated 28 Nov, 2014 11:40:08 AM



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.eshopping.*;


/**
 * ServiceImpl object for domain model class Orderdetail.
 * @see com.eshopping.Orderdetail
 */
@Service("eshopping.OrderdetailService")
public class OrderdetailServiceImpl implements OrderdetailService {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderdetailServiceImpl.class);

    @Autowired
    @Qualifier("eshopping.OrderdetailDao")
    private WMGenericDao<Orderdetail, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Orderdetail, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "eshoppingTransactionManager")
    @Override
    public Orderdetail create(Orderdetail orderdetail) {
        LOGGER.debug("Creating a new orderdetail with information: {}" , orderdetail);
        return this.wmGenericDao.create(orderdetail);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Orderdetail delete(Integer orderdetailId) throws EntityNotFoundException {
        LOGGER.debug("Deleting orderdetail with id: {}" , orderdetailId);
        Orderdetail deleted = this.wmGenericDao.findById(orderdetailId);
        if (deleted == null) {
            LOGGER.debug("No orderdetail found with id: {}" , orderdetailId);
            throw new EntityNotFoundException(String.valueOf(orderdetailId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Orderdetail> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all orderdetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Orderdetail> findAll(Pageable pageable) {
        LOGGER.debug("Finding all orderdetails");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Orderdetail findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding orderdetail by id: {}" , id);
        Orderdetail orderdetail=this.wmGenericDao.findById(id);
        if(orderdetail==null){
            LOGGER.debug("No orderdetail found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return orderdetail;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Orderdetail update(Orderdetail updated) throws EntityNotFoundException {
        LOGGER.debug("Updating orderdetail with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


