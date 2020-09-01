package com.example.demo.convertor;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;

@Component
public class DTOConvertor {
	
	public BusinessPromotionResponseDataDTO  getBusPromotionRespdataDTO(Integer price){
		BusinessPromotionResponseDataDTO data= new BusinessPromotionResponseDataDTO();
		Random random= new Random();
		data.setId(random.nextInt());
		data.setPrice(price);
		
		return data;
	}
	
	
	
	

}
