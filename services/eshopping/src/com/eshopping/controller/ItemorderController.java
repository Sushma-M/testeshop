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


import com.eshopping.service.ItemorderService;


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
 * Controller object for domain model class Itemorder.
 * @see com.eshopping.Itemorder
 */

@RestController(value = "Eshopping.ItemorderController")
@Api(value = "/eshopping/Itemorder", description = "Exposes APIs to work with Itemorder resource.")
@RequestMapping("/eshopping/Itemorder")
public class ItemorderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemorderController.class);

	@Autowired
	@Qualifier("eshopping.ItemorderService")
	private ItemorderService service;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Itemorder instances matching the search criteria.")
	public Page<Itemorder> findAll( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Itemorders list");
		return service.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Itemorder instances.")
	public Page<Itemorder> getItemorders(Pageable pageable) {
		LOGGER.debug("Rendering Itemorders list");
		return service.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Itemorder instances.")
	public Long countAll() {
		LOGGER.debug("counting Itemorders");
		Long count = service.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Itemorder instance associated with the given id.")
    public Itemorder getItemorder(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Itemorder with id: {}" , id);
        Itemorder instance = service.findById(id);
        LOGGER.debug("Itemorder details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Itemorder instance associated with the given id.")
    public boolean delete(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Itemorder with id: {}" , id);
        Itemorder deleted = service.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Itemorder instance associated with the given id.")
    public Itemorder editItemorder(@PathVariable("id") Integer id, @RequestBody Itemorder instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Itemorder with id: {}" , instance.getId());
        instance.setId(id);
        instance = service.update(instance);
        LOGGER.debug("Itemorder details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    @ApiOperation(value = "Updates the Itemorder instance associated with the given id.This API should be used when Itemorder instance fields that require multipart data.")
    public Itemorder editItemorder(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Itemorder itemorder = WMMultipartUtils.toObject(multipartHttpServletRequest,Itemorder.class);
        itemorder.setId(id);
        LOGGER.debug("Creating a new itemorder with information: {}" , itemorder);
        return service.update(itemorder);
    }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Itemorder instance.")
	public Itemorder createItemorder(@RequestBody Itemorder instance) {
		LOGGER.debug("Create Itemorder with information: {}" , instance);
		instance = service.create(instance);
		LOGGER.debug("Created Itemorder with information: {}" , instance);
	    return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ApiOperation(value = "Creates a new Itemorder instance.This API should be used when the Itemorder instance has fields that requires multipart data.")
    public Itemorder createItemorder(MultipartHttpServletRequest multipartHttpServletRequest) {
    	Itemorder itemorder = WMMultipartUtils.toObject(multipartHttpServletRequest,Itemorder.class);
        LOGGER.debug("Creating a new itemorder with information: {}" , itemorder);
        return service.create(itemorder);
    }
	
	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setItemorderService(ItemorderService service) {
		this.service = service;
	}
}

