package com.aironman.my_spring_mongo_rabbit_aop;

import java.util.Date;
import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ItemLog;
import com.aironman.my_spring_mongo_rabbit_aop.service.IItemsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationTestContext.xml"
})
public class ItemsServiceTest {

	@Autowired
	private IItemsService service;
	
	@Test
	public void testCreatewithHash(){
		
		System.out.println("testCreate...");
		
		Date dateAccesed= new Date(System.currentTimeMillis());
		String prize= "10000";
		String name = "macpro";
		String description= "pepino del carajo";
		
		ItemLog itemLog=new ItemLog(dateAccesed, name, description, prize);
		System.out.println(itemLog.hashCode());
		
		System.out.println("creating " + itemLog.toString());
		ItemLog itemCreated=service.create(itemLog);
		Assert.assertEquals(itemCreated, itemLog);
		System.out.println("created " + itemCreated.toString());
		List<ItemLog> lista = service.readAll();
		System.out.println("There are " + lista.size() + " items on system...");
		for (ItemLog item:lista){
			System.out.println("=item=" + item.toString());
		}
	}
	
	@Test
	public void testCreate(){
		
		System.out.println("testCreate...");
		Date dateAccesed= new Date(System.currentTimeMillis());
		String prize= "10000";
		String name = "macpro";
		String description= "pepino del carajo";
		ItemLog itemLog=new ItemLog(dateAccesed, name, description, prize);
		System.out.println("creating " + itemLog.toString());
		ItemLog itemCreated=service.create(itemLog);
		Assert.assertEquals(itemCreated, itemLog);
		System.out.println("created " + itemCreated.toString());
		List<ItemLog> lista = service.readAll();
		System.out.println("There are " + lista.size() + " items on system...");
		for (ItemLog item:lista){
			System.out.println("=item=" + item.toString());
		}
	}
	
	@Test
	public void testReadAndReaAll(){
		
		System.out.println("testReadAndReaAll...");
		Date dateAccesed= new Date(System.currentTimeMillis());
		String prize= "10000";
		String name = "macpro";
		String description= "pepino del carajo";
		ItemLog itemLog=new ItemLog(dateAccesed, name, description, prize);
		System.out.println("creating " + itemLog.toString());
		ItemLog itemCreated=service.create(itemLog);
		Assert.assertEquals(itemCreated, itemLog);
		System.out.println("created " + itemCreated.toString());
		List<ItemLog> lista = service.readAll();
		System.out.println("There are " + lista.size() + " items on system...");
		for (ItemLog item:lista){
			System.out.println("=item=" + item.toString());
			ItemLog itemreaded=service.read(item.getId());
			Assert.assertNotNull("el item no existe!",itemreaded);
			System.out.println("=itemreaded=" + itemreaded);
			System.out.println("=itemCreated=" + itemCreated);
			//
			Assert.assertEquals(itemCreated.getPrize(), itemreaded.getPrize());
		}
		
	}
	
	@Test
	public void testUpdate(){
		System.out.println("testUpdate...");
		String id= "3";
		Date dateAccesed= new Date(System.currentTimeMillis());
		String prize= "10000";
		String name = "macpro";
		String description= "pepino del carajo";
		ItemLog itemLog=new ItemLog(dateAccesed, name, description, prize);
		ItemLog itemCreated=service.create(itemLog);
		Assert.assertEquals(itemCreated, itemLog);
		System.out.println("created " + itemCreated.toString());
		
		List<ItemLog> lista = service.readAll();
		System.out.println("There are " + lista.size() + " items on system...");
		for (ItemLog item:lista){
			System.out.println("=item=" + item.toString());
			ItemLog itemreaded=service.read(item.getId());
			Assert.assertNotNull("el item no existe!",itemreaded);
			itemreaded.setDateAccesed(new Date(System.currentTimeMillis()));
			itemreaded.setDescription("pepino del carajoMODIFICADO");
			ItemLog itemUpdated = service.update(itemreaded);
			Assert.assertEquals(itemUpdated.getDescription(), "pepino del carajoMODIFICADO");
			System.out.println("=itemreaded=" + itemreaded);
			System.out.println("=itemCreated=" + itemCreated);
			Assert.assertEquals(itemCreated.getPrize(), itemreaded.getPrize());
		}
		
	}
	
	@Test
	public void testDelete(){
		System.out.println("testDelete...");
		Date dateAccesed= new Date(System.currentTimeMillis());
		String prize= "10000";
		String name = "macpro";
		String description= "pepino del carajo";
		ItemLog itemLog=new ItemLog( dateAccesed, name, description, prize);
		ItemLog itemCreated=service.create(itemLog);
		Assert.assertEquals(itemCreated, itemLog);
		System.out.println("created " + itemCreated.toString());
		
		List<ItemLog> lista = service.readAll();
		System.out.println("There are " + lista.size() + " items on system...");
		for (ItemLog item:lista){
			System.out.println("=item=" + item.toString());
			ItemLog itemreaded=service.read(item.getId());
			Assert.assertNotNull("el item no existe!",itemreaded);
			itemreaded.setDateAccesed(new Date(System.currentTimeMillis()));
			itemreaded.setDescription("pepino del carajoMODIFICADO");
			ItemLog itemdeleted = service.delete((itemreaded.getId()));
			System.out.println("=itemdeleted=" + itemdeleted);
			
		}
	}
}
