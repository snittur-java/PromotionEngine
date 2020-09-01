package com.example.demo.customException;

import org.springframework.stereotype.Component;

@Component
public class BusinessPromotionServiceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessPromotionServiceException(){
		
	}

	public BusinessPromotionServiceException(String message){
		super(message);
	}

}
