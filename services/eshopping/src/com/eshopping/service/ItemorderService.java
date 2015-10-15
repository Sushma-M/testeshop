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
 * Service object for domain model class Itemorder.
 * @see com.eshopping.Itemorder
 */

public interface ItemorderService {

   /**
	 * Creates a new itemorder.
	 * 
	 * @param created
	 *            The information of the created itemorder.
	 * @return The created itemorder.
	 */
	public Itemorder create(Itemorder created);

	/**
	 * Deletes a itemorder.
	 * 
	 * @param itemorderId
	 *            The id of the deleted itemorder.
	 * @return The deleted itemorder.
	 * @throws EntityNotFoundException
	 *             if no itemorder is found with the given id.
	 */
	public Itemorder delete(Integer itemorderId) throws EntityNotFoundException;

	/**
	 * Finds all itemorders.
	 * 
	 * @return A list of itemorders.
	 */
	public Page<Itemorder> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Itemorder> findAll(Pageable pageable);
	
	/**
	 * Finds itemorder by id.
	 * 
	 * @param id
	 *            The id of the wanted itemorder.
	 * @return The found itemorder. If no itemorder is found, this method returns
	 *         null.
	 */
	public Itemorder findById(Integer id) throws EntityNotFoundException;

	/**
	 * Updates the information of a itemorder.
	 * 
	 * @param updated
	 *            The information of the updated itemorder.
	 * @return The updated itemorder.
	 * @throws EntityNotFoundException
	 *             if no itemorder is found with given id.
	 */
	public Itemorder update(Itemorder updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the itemorders in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the itemorder.
	 */

	public long countAll();

}

