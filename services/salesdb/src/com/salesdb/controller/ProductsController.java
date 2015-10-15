/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.salesdb.service.ProductsService;
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
 * Controller object for domain model class Products.
 * @see com.salesdb.Products
 */
@RestController(value = "Salesdb.ProductsController")
@RequestMapping("/salesdb/Products")
@Api(description = "Exposes APIs to work with Products resource.", value = "ProductsController")
public class ProductsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    @Qualifier("salesdb.ProductsService")
    private ProductsService productsService;

    @Autowired
    @Qualifier("salesdb.SalesService")
    private SalesService salesService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Products instances matching the search criteria.")
    public Page<Products> findAll(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Productss list");
        return productsService.findAll(queryFilters, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setProductsService(ProductsService service) {
        this.productsService = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Products instances.")
    public Long countAll() {
        LOGGER.debug("counting Productss");
        Long count = productsService.countAll();
        return count;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the list of Products instances.")
    public Page<Products> getProductss(Pageable pageable) {
        LOGGER.debug("Rendering Productss list");
        return productsService.findAll(pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Products instance.")
    public Products createProducts(@RequestBody Products instance) {
        LOGGER.debug("Create Products with information: {}", instance);
        instance = productsService.create(instance);
        LOGGER.debug("Created Products with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Products instance associated with the given id.")
    public Products getProducts(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Products with id: {}", id);
        Products instance = productsService.findById(id);
        LOGGER.debug("Products details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Products instance associated with the given id.")
    public Products editProducts(@PathVariable(value = "id") Integer id, @RequestBody Products instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Products with id: {}", instance.getId());
        instance.setId(id);
        instance = productsService.update(instance);
        LOGGER.debug("Products details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Products instance associated with the given id.")
    public boolean delete(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Products with id: {}", id);
        Products deleted = productsService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}/saleses", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Gets the saleses instance associated with the given id.")
    public Page<Sales> findAssociatedsaleses(Pageable pageable, @PathVariable(value = "id") Integer id) {
        LOGGER.debug("Fetching all associated saleses");
        return salesService.findAssociatedValues(id, "products", "id", pageable);
    }
}
