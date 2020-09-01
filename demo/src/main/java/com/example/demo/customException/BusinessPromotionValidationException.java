package com.example.demo.customException;

import org.springframework.stereotype.Component;

@Component
public class BusinessPromotionValidationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessPromotionValidationException(){
		
	}

	public BusinessPromotionValidationException(String message){
		super(message);
	}

}
