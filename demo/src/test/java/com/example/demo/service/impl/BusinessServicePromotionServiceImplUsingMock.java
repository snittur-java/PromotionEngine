package com.example.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;
import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.convertor.DTOConvertor;
import com.example.demo.engine.BusinessPromotionEngine;
import com.example.demo.service.IBusisnessPromotionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServicePromotionServiceImplUsingMock {
	
	private ItemOrderRequestDTO request;
	
	@MockBean
	BusinessPromotionEngine businessPromotionEngine;
	
	@MockBean
	DTOConvertor convertor;
	
	@Autowired
	IBusisnessPromotionService service;
	
	private Map<String, Integer> itemRates;
	
	@Test
    public void testGetFinalPriceForItems() throws Exception {
		 /*Arrange*/
		request= new ItemOrderRequestDTO();
		request.setA(1);
		request.setB(1);
		request.setC(1);
		request.setD(0);
		
		itemRates= new HashMap<String, Integer>();
		itemRates.put("A", 50);
		itemRates.put("B", 30);
		itemRates.put("C", 20);
		itemRates.put("D", 15);
		
		BusinessPromotionResponseDataDTO resp= new BusinessPromotionResponseDataDTO();
		resp.setPrice(100);
		
        /*Act*/
         Mockito
        		.when(businessPromotionEngine.loadData()).thenReturn(itemRates);
         Mockito
 		.when(convertor.getBusPromotionRespdataDTO(100)).thenReturn(resp);		
 
        
        /*Assert*/
        BusinessPromotionResponseDataDTO val= service.getFinalPrice(request);
        assertTrue(val.getPrice().intValue()==100);
    }
    @Test
    public void testGetFinalPriceForItemsWithInvalid() throws Exception {
    	 /*Arrange*/
		request= new ItemOrderRequestDTO();
		request.setA(1);
		request.setB(1);
		request.setC(1);
		request.setD(0);
		
		itemRates= null;
		
		BusinessPromotionResponseDataDTO resp= new BusinessPromotionResponseDataDTO();
		resp.setPrice(370);
		
        /*Act*/
         Mockito
        		.when(businessPromotionEngine.loadData()).thenReturn(itemRates);
         Mockito
 		.when(convertor.getBusPromotionRespdataDTO(370)).thenReturn(resp);		
 
        
        /*Assert*/
        BusinessPromotionResponseDataDTO val= service.getFinalPrice(request);
        
        /*Assert*/
        assertNull("Invalid results expected ", val);
    }
    @Test
    public void testGetFinalPriceForItemsWithCorrectValue() throws Exception {
    	 /*Arrange*/
		request= null;
		itemRates= new HashMap<String, Integer>();
		itemRates.put("A", 3);
		itemRates.put("B", 5);
		itemRates.put("C", 1);
		itemRates.put("D", 1);
		
		BusinessPromotionResponseDataDTO resp= new BusinessPromotionResponseDataDTO();
		resp.setPrice(0);
		
        /*Act*/
         Mockito
        		.when(businessPromotionEngine.loadData()).thenReturn(itemRates);
         Mockito
 		.when(convertor.getBusPromotionRespdataDTO(0)).thenReturn(resp);		
 
        
        /*Assert*/
        BusinessPromotionResponseDataDTO val= service.getFinalPrice(request);
        assertFalse(val.getPrice().intValue()<0);
    }
   
   
    
	
	

}
