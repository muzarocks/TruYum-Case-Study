package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;



@SpringBootApplication
public class TruyumSpringApplication {

	@Autowired
	private static MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumSpringApplication.class);
	
	
	private static void testModifyItem()//use this test to insert or update Menu ITem Object
	{
		MenuItem menuItem=menuItemService.getMenuItem(1l);
	
		menuItem.setCategory("Starters");
		menuItemService.modifyMenuItem(menuItem);
		
	}
	private static void testGetMenuItemListAdmin()
	{
		LOGGER.info("Start");	
		LOGGER.debug("MenuItems:: {}",menuItemService.getMenuItemListAdmin());
		LOGGER.info("End");
	}
	
	private static void testGetMenuItemListCustomer()
	{
		LOGGER.info("Start");	
		LOGGER.debug("MenuItems for customer :: {}",menuItemService.getMenuItemListCustomer());
		LOGGER.info("End");
	}
	
	
	private static void testGetMenuItem(long id)
	{
		LOGGER.info("Start");	
		LOGGER.debug("Item:: {}",menuItemService.getMenuItem(id));
		LOGGER.info("End");
	}

	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(TruyumSpringApplication.class, args);
		
		
		menuItemService=context.getBean(MenuItemService.class);
		testModifyItem();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem(1l);
		
		
	}

}
