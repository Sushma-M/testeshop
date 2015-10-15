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
 * Service object for domain model class Product.
 * @see com.eshopping.Product
 */

public interface ProductService {

   /**
	 * Creates a new product.
	 * 
	 * @param created
	 *            The information of the created product.
	 * @return The created product.
	 */
	public Product create(Product created);

	/**
	 * Deletes a product.
	 * 
	 * @param productId
	 *            The id of the deleted product.
	 * @return The deleted product.
	 * @throws EntityNotFoundException
	 *             if no product is found with the given id.
	 */
	public Product delete(Integer productId) throws EntityNotFoundException;

	/**
	 * Finds all products.
	 * 
	 * @return A list of products.
	 */
	public Page<Product> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Product> findAll(Pageable pageable);
	
	/**
	 * Finds product by id.
	 * 
	 * @param id
	 *            The id of the wanted product.
	 * @return The found product. If no product is found, this method returns
	 *         null.
	 */
	public Product findById(Integer id) throws EntityNotFoundException;

	/**
	 * Updates the information of a product.
	 * 
	 * @param updated
	 *            The information of the updated product.
	 * @return The updated product.
	 * @throws EntityNotFoundException
	 *             if no product is found with given id.
	 */
	public Product update(Product updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the products in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the product.
	 */

	public long countAll();

}

