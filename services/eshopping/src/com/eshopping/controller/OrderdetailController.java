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


import com.eshopping.service.OrderdetailService;


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
 * Controller object for domain model class Orderdetail.
 * @see com.eshopping.Orderdetail
 */

@RestController(value = "Eshopping.OrderdetailController")
@Api(value = "/eshopping/Orderdetail", description = "Exposes APIs to work with Orderdetail resource.")
@RequestMapping("/eshopping/Orderdetail")
public class OrderdetailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderdetailController.class);

	@Autowired
	@Qualifier("eshopping.OrderdetailService")
	private OrderdetailService service;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Orderdetail instances matching the search criteria.")
	public Page<Orderdetail> findAll( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Orderdetails list");
		return service.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Orderdetail instances.")
	public Page<Orderdetail> getOrderdetails(Pageable pageable) {
		LOGGER.debug("Rendering Orderdetails list");
		return service.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Orderdetail instances.")
	public Long countAll() {
		LOGGER.debug("counting Orderdetails");
		Long count = service.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Orderdetail instance associated with the given id.")
    public Orderdetail getOrderdetail(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Orderdetail with id: {}" , id);
        Orderdetail instance = service.findById(id);
        LOGGER.debug("Orderdetail details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Orderdetail instance associated with the given id.")
    public boolean delete(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Orderdetail with id: {}" , id);
        Orderdetail deleted = service.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Orderdetail instance associated with the given id.")
    public Orderdetail editOrderdetail(@PathVariable("id") Integer id, @RequestBody Orderdetail instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Orderdetail with id: {}" , instance.getId());
        instance.setId(id);
        instance = service.update(instance);
        LOGGER.debug("Orderdetail details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    @ApiOperation(value = "Updates the Orderdetail instance associated with the given id.This API should be used when Orderdetail instance fields that require multipart data.")
    public Orderdetail editOrderdetail(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Orderdetail orderdetail = WMMultipartUtils.toObject(multipartHttpServletRequest,Orderdetail.class);
        orderdetail.setId(id);
        LOGGER.debug("Creating a new orderdetail with information: {}" , orderdetail);
        return service.update(orderdetail);
    }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Orderdetail instance.")
	public Orderdetail createOrderdetail(@RequestBody Orderdetail instance) {
		LOGGER.debug("Create Orderdetail with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Orderdetail with information: {}" , instance);
	    return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ApiOperation(value = "Creates a new Orderdetail instance.This API should be used when the Orderdetail instance has fields that requires multipart data.")
    public Orderdetail createOrderdetail(MultipartHttpServletRequest multipartHttpServletRequest) {
    	Orderdetail orderdetail = WMMultipartUtils.toObject(multipartHttpServletRequest,Orderdetail.class);
        LOGGER.debug("Creating a new orderdetail with information: {}" , orderdetail);
        return service.create(orderdetail);
    }
	
	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setOrderdetailService(OrderdetailService service) {
		this.service = service;
	}
}

