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
// Generated Thu Mar 19 09:51:47 IST 2015

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;

import  com.eshopping.service.EshoppingProcedureExecutorService;
import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.*;

@RestController(value = "Eshopping.ProcedureExecutionController")
@Api(value = "/eshopping/procedureExecutor", description = "Controller class for procedure execution")
@RequestMapping("/eshopping/procedureExecutor")
public class ProcedureExecutionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureExecutionController.class);

	@Autowired
	private EshoppingProcedureExecutorService procedureService;
	
	

	@RequestMapping(value = "/procedure/execute/wm_custom", method = RequestMethod.POST)
	@ApiOperation(value = "Process request to execute custom Procedure")
	public List<Object> executeWMCustomProcedure(@RequestBody CustomProcedure procedure) {
		List<Object> result = procedureService.executeWMCustomProcedure(procedure);
		LOGGER.debug("got the result {}" + result);
		return result;
	}



}

