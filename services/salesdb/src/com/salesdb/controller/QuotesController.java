/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.salesdb.service.FollowUpsService;
import com.salesdb.service.QuotesService;
import com.salesdb.service.SalesService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
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
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.*;
import com.salesdb.*;
import com.salesdb.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Quotes.
 * @see com.salesdb.Quotes
 */
@RestController(value = "Salesdb.QuotesController")
@RequestMapping("/salesdb/Quotes")
@Api(description = "Exposes APIs to work with Quotes resource.", value = "QuotesController")
public class QuotesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuotesController.class);

    @Autowired
    @Qualifier("salesdb.QuotesService")
    private QuotesService quotesService;

    @Autowired
    @Qualifier("salesdb.SalesService")
    private SalesService salesService;

    @Autowired
    @Qualifier("salesdb.FollowUpsService")
    private FollowUpsService followUpsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Quotes instances matching the search criteria.")
    public Page<Quotes> findAll(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Quotess list");
        return quotesService.findAll(queryFilters, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setQuotesService(QuotesService service) {
        this.quotesService = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Quotes instances.")
    public Long countAll() {
        LOGGER.debug("counting Quotess");
        Long count = quotesService.countAll();
        return count;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the list of Quotes instances.")
    public Page<Quotes> getQuotess(Pageable pageable) {
        LOGGER.debug("Rendering Quotess list");
        return quotesService.findAll(pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Quotes instance.")
    public Quotes createQuotes(@RequestBody Quotes instance) {
        LOGGER.debug("Create Quotes with information: {}", instance);
        instance = quotesService.create(instance);
        LOGGER.debug("Created Quotes with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Quotes instance associated with the given id.")
    public Quotes getQuotes(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Quotes with id: {}", id);
        Quotes instance = quotesService.findById(id);
        LOGGER.debug("Quotes details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Quotes instance associated with the given id.")
    public Quotes editQuotes(@PathVariable(value = "id") Integer id, @RequestBody Quotes instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Quotes with id: {}", instance.getId());
        instance.setId(id);
        instance = quotesService.update(instance);
        LOGGER.debug("Quotes details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Quotes instance associated with the given id.")
    public boolean delete(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Quotes with id: {}", id);
        Quotes deleted = quotesService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}/saleses", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Gets the saleses instance associated with the given id.")
    public Page<Sales> findAssociatedsaleses(Pageable pageable, @PathVariable(value = "id") Integer id) {
        LOGGER.debug("Fetching all associated saleses");
        return salesService.findAssociatedValues(id, "quotes", "id", pageable);
    }

    @RequestMapping(value = "/{id:.+}/followUpses", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Gets the followUpses instance associated with the given id.")
    public Page<FollowUps> findAssociatedfollowUpses(Pageable pageable, @PathVariable(value = "id") Integer id) {
        LOGGER.debug("Fetching all associated followUpses");
        return followUpsService.findAssociatedValues(id, "quotes", "id", pageable);
    }
}
