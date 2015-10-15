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
 * Service object for domain model class Productorder.
 * @see com.eshopping.Productorder
 */

public interface ProductorderService {

   /**
	 * Creates a new productorder.
	 * 
	 * @param created
	 *            The information of the created productorder.
	 * @return The created productorder.
	 */
	public Productorder create(Productorder created);

	/**
	 * Deletes a productorder.
	 * 
	 * @param productorderId
	 *            The id of the deleted productorder.
	 * @return The deleted productorder.
	 * @throws EntityNotFoundException
	 *             if no productorder is found with the given id.
	 */
	public Productorder delete(Integer productorderId) throws EntityNotFoundException;

	/**
	 * Finds all productorders.
	 * 
	 * @return A list of productorders.
	 */
	public Page<Productorder> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Productorder> findAll(Pageable pageable);
	
	/**
	 * Finds productorder by id.
	 * 
	 * @param id
	 *            The id of the wanted productorder.
	 * @return The found productorder. If no productorder is found, this method returns
	 *         null.
	 */
	public Productorder findById(Integer id) throws EntityNotFoundException;

	/**
	 * Updates the information of a productorder.
	 * 
	 * @param updated
	 *            The information of the updated productorder.
	 * @return The updated productorder.
	 * @throws EntityNotFoundException
	 *             if no productorder is found with given id.
	 */
	public Productorder update(Productorder updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the productorders in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the productorder.
	 */

	public long countAll();

}

