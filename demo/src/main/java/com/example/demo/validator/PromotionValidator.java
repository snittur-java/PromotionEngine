package com.example.demo.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.customException.BusinessPromotionValidationException;

@Component
public class PromotionValidator {
	private static final Logger logger = LogManager.getLogger(PromotionValidator.class);
	
public void	validate(ItemOrderRequestDTO request) throws BusinessPromotionValidationException{
		if(request==null || request.getA()==null || request.getB()==null || request.getC()==null
				|| request.getD()==null){
			logger.info("inside PromotionValidator throwing exception");
			throw new BusinessPromotionValidationException("Please provide valid data");
			
		}
	}

}
