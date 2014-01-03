package com.mongotest;


import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
public class DBTest {

//	public static void main(String[] args) throws Exception {		 
//
//	
//        //Preparing insert
//		
//        Parent parent = new Parent();
//        parent.setNo(1L);
//        parent.setName("Bill Sr.");
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(parent);
//        BasicDBObject doc = new BasicDBObject("StudentID",2).
//                append("FirstName", "William").
//                append("LastName", "Spizer").
//				append("date", new Date()).
//				append("rand", Math.random()).
//				append("Parents",json);
//
//        System.out.println("Insert----------\n"+doc);
//		MongoDAO.insertObject(doc);	
//
//		// Test Readback
//		
//		BasicDBObject searchQuery = new BasicDBObject();
//		searchQuery.put("StudentID", 2);
//		DBObject oldObj = MongoDAO.getObject(searchQuery);
//		System.out.println("Read----------\n"+oldObj);		
//		DBObject newObj= new BasicDBObject();
//		newObj.putAll(oldObj);
//		
//	// preparing update	
//
//		newObj.put("rand", Math.random());
//		newObj.put("FirstName", "Bill");
//		newObj.put("LastName", "Speiser");
//		newObj.put("date", new Date());
//		parent.setName("William III");
//		parent.setNo(3);
//		json = gson.toJson(parent);		
//        newObj.put("foo", json);
//        MongoDAO.updateObject(oldObj,newObj);
//		searchQuery.put("StudentID", 2);
//		
//		System.out.println("Update----------\n"+newObj);		        
// 
////verifying update		
//		oldObj = MongoDAO.getObject(searchQuery);
//		System.out.println("Read Update----------\n"+oldObj);	
//
//// Deleting		
//		newObj = MongoDAO.getObject(searchQuery);		
//		MongoDAO.removeObject(oldObj);
//
////verifying delete
//		newObj = MongoDAO.getObject(searchQuery);		
//		System.out.println("Confirm Delete-------\n"+ newObj);
//
//		
//	}
//
//

}
