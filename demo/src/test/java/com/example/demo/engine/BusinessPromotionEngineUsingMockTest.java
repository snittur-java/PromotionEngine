package com.example.demo.engine;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.ItemOrder;
import com.example.demo.repository.PromotionPriceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessPromotionEngineUsingMockTest {
	
	@MockBean
	PromotionPriceRepository repository;
	
	
	Iterable<ItemOrder> orderlist;
	
	@Before
	public void init(){
		
	}

	@Test
    public void testValidPrice() throws Exception {
        /*Arrange*/
		List<ItemOrder> mylist= new ArrayList<>();
		ItemOrder a= new ItemOrder();
		ItemOrder b= new ItemOrder();
		ItemOrder c= new ItemOrder();
		a.setId(1);
		a.setItemName("A");
		a.setItemPrice(100);
		a.setId(2);
		b.setItemName("B");
		b.setItemPrice(1000);
		b.setId(1);
		c.setItemName("C");
		c.setItemPrice(10000);
		mylist.add(a);
		mylist.add(b);
		mylist.add(c);
		
        /*Act*/
		Mockito.when(repository.findAll()).thenReturn(mylist);
        
        /*Assert*/
        assertTrue(mylist.size()>0);
    }
    @Test
    public void testInvalidPrice() throws Exception {
    	   /*Arrange*/
    			List<ItemOrder> mylist= null;
    			
    	        /*Act*/
    			Mockito.when(repository.findAll()).thenReturn(mylist);
    	        
        
        /*Assert*/
        assertNull("no data got from db ", mylist);
    }
	
	

}
