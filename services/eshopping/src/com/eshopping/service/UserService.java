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




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.eshopping.*;

/**
 * Service object for domain model class User.
 * @see com.eshopping.User
 */

public interface UserService {

   /**
	 * Creates a new user.
	 * 
	 * @param created
	 *            The information of the created user.
	 * @return The created user.
	 */
	public User create(User created);

	/**
	 * Deletes a user.
	 * 
	 * @param userId
	 *            The id of the deleted user.
	 * @return The deleted user.
	 * @throws EntityNotFoundException
	 *             if no user is found with the given id.
	 */
	public User delete(Integer userId) throws EntityNotFoundException;

	/**
	 * Finds all users.
	 * 
	 * @return A list of users.
	 */
	public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<User> findAll(Pageable pageable);
	
	/**
	 * Finds user by id.
	 * 
	 * @param id
	 *            The id of the wanted user.
	 * @return The found user. If no user is found, this method returns
	 *         null.
	 */
	public User findById(Integer id) throws EntityNotFoundException;

	/**
	 * Updates the information of a user.
	 * 
	 * @param updated
	 *            The information of the updated user.
	 * @return The updated user.
	 * @throws EntityNotFoundException
	 *             if no user is found with given id.
	 */
	public User update(User updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the users in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the user.
	 */

	public long countAll();

}

