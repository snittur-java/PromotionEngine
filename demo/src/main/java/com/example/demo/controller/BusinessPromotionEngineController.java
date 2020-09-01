package com.example.demo.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;
import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.customException.BusinessPromotionServiceException;
import com.example.demo.customException.BusinessPromotionValidationException;
import com.example.demo.service.IBusisnessPromotionService;
import com.example.demo.validator.PromotionValidator;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/promotion")
public class BusinessPromotionEngineController {
	
	private static final Logger logger = LogManager.getLogger(BusinessPromotionEngineController.class);
	
	@Autowired
	IBusisnessPromotionService promotion;
	
	@Autowired
	PromotionValidator validator;
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/price", method= RequestMethod.POST,produces = "application/json")
	public BusinessPromotionResponseDataDTO getFinalPriceForItems(@RequestBody ItemOrderRequestDTO request) 
			throws BusinessPromotionServiceException,BusinessPromotionValidationException{
		validator.validate(request);
		logger.info("Inside the controller - gettingFinalPrice");
		return promotion.getFinalPrice(request);
		
	}
	
}
