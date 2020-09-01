package com.example.demo.engine;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.BusinessPromotionEngineController;
import com.example.demo.model.ItemOrder;
import com.example.demo.repository.PromotionPriceRepository;

@Component
public class BusinessPromotionEngine {
	
	private static final Logger logger = LogManager.getLogger(BusinessPromotionEngine.class);

	private Map<String, Integer> itemRates;
	
	@Autowired
	PromotionPriceRepository repsository;
	
	public Map<String, Integer> loadData() {
		
		itemRates= new HashMap<String, Integer>();
		Iterable<ItemOrder> orderlist =repsository.findAll();
		if(orderlist==null){
			logger.info("loading from in memory database failed");
			itemRates= loadStaticData(itemRates);
			return itemRates;
		}
		else{
			logger.info("Inside the BusinessPromotionEngine - loadingdata from in memory");
			orderlist.forEach(item->{
			itemRates.put(item.getItemName(), item.getItemPrice());
			});
			
		}
		return itemRates;
	}

	private Map<String, Integer> loadStaticData(Map<String, Integer> itemRates) {
		logger.info("Inside the BusinessPromotionEngine - loadingdata statically");
		itemRates= new HashMap<String, Integer>();
		itemRates.put("A", 50);
		itemRates.put("B", 30);
		itemRates.put("C", 20);
		itemRates.put("D", 15);
		return itemRates;
	}

}
