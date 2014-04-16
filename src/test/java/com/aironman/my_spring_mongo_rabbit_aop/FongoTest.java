package com.aironman.my_spring_mongo_rabbit_aop;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ItemLog;
import com.github.fakemongo.Fongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class FongoTest {
	
	@Test
	public void test(){
		Fongo fongo = new Fongo("mongo server 1");

		// once you have a DB instance, you can interact with it
		// just like you would with a real one.
		DB db = fongo.getDB("mylocaldb");
		DBCollection collection = db.getCollection("mycollection");
		
//		collection.insert(new BasicDBObject("name", "jon"));
		ItemLog myItem = new ItemLog(new Date(System.currentTimeMillis()), "a name", "some description", "50000");
		collection.insert(new BasicDBObject("myItem", myItem));
		// get all created databases (they are created automatically the first time requested)
		Collection<DB> dbs = fongo.getUsedDatabases();
		for (DB adb : dbs){
			System.out.println("db: " + adb.toString());
		}
		// also
		List<String> dbNames = fongo.getDatabaseNames();
		for (String dbname: dbNames){
			System.out.println("dbname: " + dbname);
		}
		// also
//		fongo.dropDatabase("dbName");
		
		// get an instance of the hijacked com.mongodb.Mongo
		Mongo mongo = fongo.getMongo();
	}

}
