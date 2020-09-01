package com.example.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;
import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.service.IBusisnessPromotionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServicePromotionServiceImplTest {
	
	private ItemOrderRequestDTO request;
	
	@Autowired
	IBusisnessPromotionService service;
	
	@Test
    public void testGetFinalPriceForItems() throws Exception {
		 /*Arrange*/
		request= new ItemOrderRequestDTO();
		request.setA(1);
		request.setB(1);
		request.setC(1);
		request.setD(0);
		
        /*Act*/
        BusinessPromotionResponseDataDTO result = service.getFinalPrice(request);
        
        /*Assert*/
        assertTrue(result.getPrice().intValue()==100);
    }
    @Test
    public void testGetFinalPriceForItemsWithInvalid() throws Exception {
    	/*Arrange*/
		request= new ItemOrderRequestDTO();
		request.setA(1);
		request.setB(1);
		request.setC(0);
		request.setD(0);
		
        /*Act*/
        BusinessPromotionResponseDataDTO result = service.getFinalPrice(request);
        
        /*Assert*/
        assertFalse("Invalid results expected ", result.getPrice()==0);
    }
    @Test
    public void testGetFinalPriceForItemsWithCorrectValue() throws Exception {
        /*Arrange*/
    	request= new ItemOrderRequestDTO();
		request.setA(5);
		request.setB(5);
		request.setC(1);
		request.setD(0);
        /*Act*/
		BusinessPromotionResponseDataDTO result = service.getFinalPrice(request);
        /*Assert*/
        assertEquals("priceof the above cart value ", 370, result.getPrice().intValue());
    }
    @Test
    public void testGetFinalPriceForItemsWithIncorrectCorrectValue() throws Exception {
    	  /*Arrange*/
    	request= new ItemOrderRequestDTO();
		request.setA(-5);
		request.setB(-5);
		request.setC(-1);
		request.setD(0);
        /*Act*/
		BusinessPromotionResponseDataDTO result = service.getFinalPrice(request);
        /*Assert*/
        assertNotEquals("priceof the above cart value", 100, result.getPrice().intValue());
    }
    @Test
    public void testGetFinalPriceForItemsWithNullValue() throws Exception {
    	/*Arrange*/
    	request= new ItemOrderRequestDTO();
		request.setA(5);
		request.setB(5);
		request.setC(1);
		request.setD(0);
        /*Act*/
		BusinessPromotionResponseDataDTO result = service.getFinalPrice(request);
        /*Assert*/
        assertNotNull("Returned null for existing employee", result.getPrice());
    }
   
    
	
	

}
