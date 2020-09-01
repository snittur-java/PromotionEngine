package com.example.demo.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DTO.BusinessPromotionResponseDataDTO;
import com.example.demo.DTO.ItemOrderRequestDTO;
import com.example.demo.controller.BusinessPromotionEngineController;
import com.example.demo.customException.BusinessPromotionValidationException;
import com.example.demo.service.IBusisnessPromotionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessPromotionControllerUsingMockTest {
	
	@MockBean
	IBusisnessPromotionService service;
	
	
	private ItemOrderRequestDTO request;
	
	@Autowired
	BusinessPromotionEngineController controller;
	
	@Before
	public void init(){
		
	}

	@Test
    public void testgetFinalPriceForItems() throws Exception {
        /*Arrange*/
		request= new ItemOrderRequestDTO();
		request.setA(5);
		request.setB(5);
		request.setC(1);
		request.setD(0);
		
		BusinessPromotionResponseDataDTO data= new BusinessPromotionResponseDataDTO();
		data.setPrice(370);
		
        /*Act*/
		Mockito.when(service.getFinalPrice(request)).thenReturn(data);
		
		controller.getFinalPriceForItems(request);
        
        /*Assert*/
        assertTrue(data.getPrice()>0);
    }
    @Test
    public void testInvalidgetFinalPriceForItems2() throws Exception {
    	 /*Arrange*/
		request= new ItemOrderRequestDTO();
		request.setA(5);
		request.setB(5);
		request.setC(1);
		request.setD(0);
		
		BusinessPromotionResponseDataDTO data= new BusinessPromotionResponseDataDTO();
		data.setPrice(370);
		
        /*Act*/
		Mockito.when(service.getFinalPrice(request)).thenReturn(data);
		controller.getFinalPriceForItems(request);
        
        /*Assert*/
        assertFalse(data.getPrice()<0);
    }
    
    @Test(expected = BusinessPromotionValidationException.class)
    public void testInvalidgetFinalPriceForItems() throws Exception {
    	 /*Arrange*/
		request= null;
		
		BusinessPromotionResponseDataDTO data= new BusinessPromotionResponseDataDTO();
		data.setPrice(370);
		controller.getFinalPriceForItems(request);
        /*Act*/
		Mockito.when(service.getFinalPrice(request)).thenThrow(BusinessPromotionValidationException.class);
        
    }
	
	

}
