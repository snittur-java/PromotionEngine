package com.example.demo.impl;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;
import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.constants.ORDERTYPE;
import com.example.demo.convertor.DTOConvertor;
import com.example.demo.customException.BusinessPromotionServiceException;
import com.example.demo.engine.BusinessPromotionEngine;
import com.example.demo.service.IBusisnessPromotionService;
;

@Service
public class BusinessServicePromotionServiceImpl implements IBusisnessPromotionService{
	
	private static final Logger logger = LogManager.getLogger(BusinessServicePromotionServiceImpl.class);
	@Autowired 
	BusinessPromotionEngine businessPromotionEngine;
	
	@Autowired
	DTOConvertor convertor;
	
	private Map<String, Integer> itemRates;
	
	@Override
	public BusinessPromotionResponseDataDTO getFinalPrice(ItemOrderRequestDTO request) throws 
	BusinessPromotionServiceException{
		logger.info("inside BusinessServicePromotionServiceImpl getFinalPrice" + request);
		itemRates= businessPromotionEngine.loadData();
		Integer finalPrice= getFinalPriceForItems(request);
		BusinessPromotionResponseDataDTO resp= convertor.getBusPromotionRespdataDTO(finalPrice);
		return resp;
	}

	
	public Integer getFinalPriceForItems(ItemOrderRequestDTO itemOrder) {
		int finalPrice = 0;
		if (itemOrder != null) {
			
			if (itemOrder.getA()!=null && itemOrder.getA() >= 0 && 
			itemOrder.getB()!=null && itemOrder.getB() >= 0 && 
			itemOrder.getC()!=null && itemOrder.getC() >= 0  &&
					 itemOrder.getD()!=null	&& itemOrder.getD() >= 0)
				finalPrice = getCostForItemA(itemOrder.getA()) + getCostForItemB(itemOrder.getB())
						+ getCostForCandD(itemOrder.getC(), itemOrder.getD());

		}
		return finalPrice;
	}

	private Integer getCostForItemA(int orderCount) {
		logger.info("inside BusinessServicePromotionServiceImpl getCostForItemA" + orderCount);
		int cost = 0;
		int divisor = orderCount / 3;
		int remaining = orderCount % 3;
		if(itemRates!=null && itemRates.get(ORDERTYPE.A.toString())!=null){
			cost = (divisor * 130) + (remaining * itemRates.get(ORDERTYPE.A.toString()));
		}
		
		return cost;
	}

	private Integer getCostForItemB(int orderCount) {
		logger.info("inside BusinessServicePromotionServiceImpl getCostForItemB" + orderCount);
		int cost = 0;
		int divisor = orderCount / 2;
		int remaining = orderCount % 2;
		if(itemRates!=null && itemRates.get(ORDERTYPE.B.toString())!=null){
			cost = (divisor * 45) + (remaining * itemRates.get(ORDERTYPE.B.toString()));
		}
		
		return cost;
	}

	private Integer getCostForCandD(int orderCountC, int orderCountD) {
		logger.info("inside BusinessServicePromotionServiceImpl getCostForCandD" +  orderCountC , orderCountC);
		int cost = 0;
		int totalOrderCount = orderCountC + orderCountD;
		int divisor = totalOrderCount / 2;
		if(itemRates!=null && itemRates.get(ORDERTYPE.C.toString())!=null && itemRates.get(ORDERTYPE.D.toString())!=null){
			cost = (divisor * 30) + ((orderCountC - divisor) * itemRates.get(ORDERTYPE.C.toString()) + (orderCountD - divisor) * itemRates.get(ORDERTYPE.D.toString()));
		}
		
		return cost;
	}

	
}
