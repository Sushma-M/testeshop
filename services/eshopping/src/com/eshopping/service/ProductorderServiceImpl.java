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
 * ServiceImpl object for domain model class Productorder.
 * @see com.eshopping.Productorder
 */
@Service("eshopping.ProductorderService")
public class ProductorderServiceImpl implements ProductorderService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorderServiceImpl.class);

    @Autowired
    @Qualifier("eshopping.ProductorderDao")
    private WMGenericDao<Productorder, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Productorder, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "eshoppingTransactionManager")
    @Override
    public Productorder create(Productorder productorder) {
        LOGGER.debug("Creating a new productorder with information: {}" , productorder);
        return this.wmGenericDao.create(productorder);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Productorder delete(Integer productorderId) throws EntityNotFoundException {
        LOGGER.debug("Deleting productorder with id: {}" , productorderId);
        Productorder deleted = this.wmGenericDao.findById(productorderId);
        if (deleted == null) {
            LOGGER.debug("No productorder found with id: {}" , productorderId);
            throw new EntityNotFoundException(String.valueOf(productorderId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Productorder> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all productorders");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Productorder> findAll(Pageable pageable) {
        LOGGER.debug("Finding all productorders");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Productorder findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding productorder by id: {}" , id);
        Productorder productorder=this.wmGenericDao.findById(id);
        if(productorder==null){
            LOGGER.debug("No productorder found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return productorder;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Productorder update(Productorder updated) throws EntityNotFoundException {
        LOGGER.debug("Updating productorder with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


