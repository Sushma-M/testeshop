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
 * ServiceImpl object for domain model class Itemorder.
 * @see com.eshopping.Itemorder
 */
@Service("eshopping.ItemorderService")
public class ItemorderServiceImpl implements ItemorderService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ItemorderServiceImpl.class);

    @Autowired
    @Qualifier("eshopping.ItemorderDao")
    private WMGenericDao<Itemorder, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Itemorder, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "eshoppingTransactionManager")
    @Override
    public Itemorder create(Itemorder itemorder) {
        LOGGER.debug("Creating a new itemorder with information: {}" , itemorder);
        return this.wmGenericDao.create(itemorder);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Itemorder delete(Integer itemorderId) throws EntityNotFoundException {
        LOGGER.debug("Deleting itemorder with id: {}" , itemorderId);
        Itemorder deleted = this.wmGenericDao.findById(itemorderId);
        if (deleted == null) {
            LOGGER.debug("No itemorder found with id: {}" , itemorderId);
            throw new EntityNotFoundException(String.valueOf(itemorderId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Itemorder> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all itemorders");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Itemorder> findAll(Pageable pageable) {
        LOGGER.debug("Finding all itemorders");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Itemorder findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding itemorder by id: {}" , id);
        Itemorder itemorder=this.wmGenericDao.findById(id);
        if(itemorder==null){
            LOGGER.debug("No itemorder found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return itemorder;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Itemorder update(Itemorder updated) throws EntityNotFoundException {
        LOGGER.debug("Updating itemorder with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


