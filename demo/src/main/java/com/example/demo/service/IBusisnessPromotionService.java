package com.example.demo.service;


import org.springframework.stereotype.Component;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;
import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.customException.BusinessPromotionServiceException;


@Component
public interface IBusisnessPromotionService {
	
	BusinessPromotionResponseDataDTO getFinalPrice(ItemOrderRequestDTO request) throws BusinessPromotionServiceException;

	

}
