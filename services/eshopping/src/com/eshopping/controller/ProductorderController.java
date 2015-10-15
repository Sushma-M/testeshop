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


import com.eshopping.service.ProductorderService;


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
 * Controller object for domain model class Productorder.
 * @see com.eshopping.Productorder
 */

@RestController(value = "Eshopping.ProductorderController")
@Api(value = "/eshopping/Productorder", description = "Exposes APIs to work with Productorder resource.")
@RequestMapping("/eshopping/Productorder")
public class ProductorderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorderController.class);

	@Autowired
	@Qualifier("eshopping.ProductorderService")
	private ProductorderService service;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Productorder instances matching the search criteria.")
	public Page<Productorder> findAll( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Productorders list");
		return service.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Productorder instances.")
	public Page<Productorder> getProductorders(Pageable pageable) {
		LOGGER.debug("Rendering Productorders list");
		return service.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Productorder instances.")
	public Long countAll() {
		LOGGER.debug("counting Productorders");
		Long count = service.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Productorder instance associated with the given id.")
    public Productorder getProductorder(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Productorder with id: {}" , id);
        Productorder instance = service.findById(id);
        LOGGER.debug("Productorder details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Productorder instance associated with the given id.")
    public boolean delete(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Productorder with id: {}" , id);
        Productorder deleted = service.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Productorder instance associated with the given id.")
    public Productorder editProductorder(@PathVariable("id") Integer id, @RequestBody Productorder instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Productorder with id: {}" , instance.getId());
        instance.setId(id);
        instance = service.update(instance);
        LOGGER.debug("Productorder details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    @ApiOperation(value = "Updates the Productorder instance associated with the given id.This API should be used when Productorder instance fields that require multipart data.")
    public Productorder editProductorder(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Productorder productorder = WMMultipartUtils.toObject(multipartHttpServletRequest,Productorder.class);
        productorder.setId(id);
        LOGGER.debug("Creating a new productorder with information: {}" , productorder);
        return service.update(productorder);
    }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Productorder instance.")
	public Productorder createProductorder(@RequestBody Productorder instance) {
		LOGGER.debug("Create Productorder with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Productorder with information: {}" , instance);
	    return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ApiOperation(value = "Creates a new Productorder instance.This API should be used when the Productorder instance has fields that requires multipart data.")
    public Productorder createProductorder(MultipartHttpServletRequest multipartHttpServletRequest) {
    	Productorder productorder = WMMultipartUtils.toObject(multipartHttpServletRequest,Productorder.class);
        LOGGER.debug("Creating a new productorder with information: {}" , productorder);
        return service.create(productorder);
    }
	
	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setProductorderService(ProductorderService service) {
		this.service = service;
	}
}

