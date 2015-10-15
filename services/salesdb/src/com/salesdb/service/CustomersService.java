/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;

/**
 * Service object for domain model class Customers.
 * @see com.salesdb.Customers
 */

public interface CustomersService {
   /**
	 * Creates a new customers.
	 * 
	 * @param created
	 *            The information of the created customers.
	 * @return The created customers.
	 */
	public Customers create(Customers created);

	/**
	 * Deletes a customers.
	 * 
	 * @param customersId
	 *            The id of the deleted customers.
	 * @return The deleted customers.
	 * @throws EntityNotFoundException
	 *             if no customers is found with the given id.
	 */
	public Customers delete(Integer customersId) throws EntityNotFoundException;

	/**
	 * Finds all customerss.
	 * 
	 * @return A list of customerss.
	 */
	public Page<Customers> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Customers> findAll(Pageable pageable);
	
	/**
	 * Finds customers by id.
	 * 
	 * @param id
	 *            The id of the wanted customers.
	 * @return The found customers. If no customers is found, this method returns
	 *         null.
	 */
	public Customers findById(Integer id) throws EntityNotFoundException;
	/**
	 * Updates the information of a customers.
	 * 
	 * @param updated
	 *            The information of the updated customers.
	 * @return The updated customers.
	 * @throws EntityNotFoundException
	 *             if no customers is found with given id.
	 */
	public Customers update(Customers updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the customerss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the customers.
	 */

	public long countAll();


    public Page<Customers> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

