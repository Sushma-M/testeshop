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
 * Service object for domain model class Orderdetail.
 * @see com.eshopping.Orderdetail
 */

public interface OrderdetailService {

   /**
	 * Creates a new orderdetail.
	 * 
	 * @param created
	 *            The information of the created orderdetail.
	 * @return The created orderdetail.
	 */
	public Orderdetail create(Orderdetail created);

	/**
	 * Deletes a orderdetail.
	 * 
	 * @param orderdetailId
	 *            The id of the deleted orderdetail.
	 * @return The deleted orderdetail.
	 * @throws EntityNotFoundException
	 *             if no orderdetail is found with the given id.
	 */
	public Orderdetail delete(Integer orderdetailId) throws EntityNotFoundException;

	/**
	 * Finds all orderdetails.
	 * 
	 * @return A list of orderdetails.
	 */
	public Page<Orderdetail> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Orderdetail> findAll(Pageable pageable);
	
	/**
	 * Finds orderdetail by id.
	 * 
	 * @param id
	 *            The id of the wanted orderdetail.
	 * @return The found orderdetail. If no orderdetail is found, this method returns
	 *         null.
	 */
	public Orderdetail findById(Integer id) throws EntityNotFoundException;

	/**
	 * Updates the information of a orderdetail.
	 * 
	 * @param updated
	 *            The information of the updated orderdetail.
	 * @return The updated orderdetail.
	 * @throws EntityNotFoundException
	 *             if no orderdetail is found with given id.
	 */
	public Orderdetail update(Orderdetail updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the orderdetails in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the orderdetail.
	 */

	public long countAll();

}

