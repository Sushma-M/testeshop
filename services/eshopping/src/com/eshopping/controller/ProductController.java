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
package com.eshopping.controller; 

// Generated 28 Nov, 2014 11:40:08 AM


import com.eshopping.service.ProductService;


import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wordnik.swagger.annotations.*;

import com.eshopping.*;


/**
 * Controller object for domain model class Product.
 * @see com.eshopping.Product
 */

@RestController(value = "Eshopping.ProductController")
@Api(value = "/eshopping/Product", description = "Exposes APIs to work with Product resource.")
@RequestMapping("/eshopping/Product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	@Qualifier("eshopping.ProductService")
	private ProductService service;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Product instances matching the search criteria.")
	public Page<Product> findAll( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Products list");
		return service.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Product instances.")
	public Page<Product> getProducts(Pageable pageable) {
		LOGGER.debug("Rendering Products list");
		return service.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Product instances.")
	public Long countAll() {
		LOGGER.debug("counting Products");
		Long count = service.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Product instance associated with the given id.")
    public Product getProduct(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Product with id: {}" , id);
        Product instance = service.findById(id);
        LOGGER.debug("Product details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Product instance associated with the given id.")
    public boolean delete(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Product with id: {}" , id);
        Product deleted = service.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Product instance associated with the given id.")
    public Product editProduct(@PathVariable("id") Integer id, @RequestBody Product instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Product with id: {}" , instance.getId());
        instance.setId(id);
        instance = service.update(instance);
        LOGGER.debug("Product details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    @ApiOperation(value = "Updates the Product instance associated with the given id.This API should be used when Product instance fields that require multipart data.")
    public Product editProduct(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Product product = WMMultipartUtils.toObject(multipartHttpServletRequest,Product.class);
        product.setId(id);
        LOGGER.debug("Creating a new product with information: {}" , product);
        return service.update(product);
    }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Product instance.")
	public Product createProduct(@RequestBody Product instance) {
		LOGGER.debug("Create Product with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Product with information: {}" , instance);
	    return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ApiOperation(value = "Creates a new Product instance.This API should be used when the Product instance has fields that requires multipart data.")
    public Product createProduct(MultipartHttpServletRequest multipartHttpServletRequest) {
    	Product product = WMMultipartUtils.toObject(multipartHttpServletRequest,Product.class);
        LOGGER.debug("Creating a new product with information: {}" , product);
        return service.create(product);
    }
	
	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setProductService(ProductService service) {
		this.service = service;
	}
}

