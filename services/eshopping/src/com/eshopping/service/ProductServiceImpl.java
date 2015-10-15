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
 * ServiceImpl object for domain model class Product.
 * @see com.eshopping.Product
 */
@Service("eshopping.ProductService")
public class ProductServiceImpl implements ProductService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    @Qualifier("eshopping.ProductDao")
    private WMGenericDao<Product, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Product, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "eshoppingTransactionManager")
    @Override
    public Product create(Product product) {
        LOGGER.debug("Creating a new product with information: {}" , product);
        return this.wmGenericDao.create(product);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Product delete(Integer productId) throws EntityNotFoundException {
        LOGGER.debug("Deleting product with id: {}" , productId);
        Product deleted = this.wmGenericDao.findById(productId);
        if (deleted == null) {
            LOGGER.debug("No product found with id: {}" , productId);
            throw new EntityNotFoundException(String.valueOf(productId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Product> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all products");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<Product> findAll(Pageable pageable) {
        LOGGER.debug("Finding all products");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Product findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding product by id: {}" , id);
        Product product=this.wmGenericDao.findById(id);
        if(product==null){
            LOGGER.debug("No product found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return product;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public Product update(Product updated) throws EntityNotFoundException {
        LOGGER.debug("Updating product with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


