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
 * ServiceImpl object for domain model class User.
 * @see com.eshopping.User
 */
@Service("eshopping.UserService")
public class UserServiceImpl implements UserService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    @Qualifier("eshopping.UserDao")
    private WMGenericDao<User, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<User, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "eshoppingTransactionManager")
    @Override
    public User create(User user) {
        LOGGER.debug("Creating a new user with information: {}" , user);
        return this.wmGenericDao.create(user);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public User delete(Integer userId) throws EntityNotFoundException {
        LOGGER.debug("Deleting user with id: {}" , userId);
        User deleted = this.wmGenericDao.findById(userId);
        if (deleted == null) {
            LOGGER.debug("No user found with id: {}" , userId);
            throw new EntityNotFoundException(String.valueOf(userId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all users");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public Page<User> findAll(Pageable pageable) {
        LOGGER.debug("Finding all users");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public User findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding user by id: {}" , id);
        User user=this.wmGenericDao.findById(id);
        if(user==null){
            LOGGER.debug("No user found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return user;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "eshoppingTransactionManager")
    @Override
    public User update(User updated) throws EntityNotFoundException {
        LOGGER.debug("Updating user with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "eshoppingTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


