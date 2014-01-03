package com.mongotest;


import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
public class LoginSercive {

	public static void main(String[] args) throws Exception {		 

	
        //Preparing insert
        BasicDBObject doc = new BasicDBObject("SiteId",123).
                append("URL", "www.google.com").
                append("Username", "w_speiser").
				append("Password", "pass").
        		append("date", new Date());

		System.out.println("Insert----------\n"+doc);
        MongoLoginDAO.insertLogin(doc);	

		// Test Readback
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("SiteId", 123);
		DBObject oldObj = MongoLoginDAO.getLogin(searchQuery);
		System.out.println("Read----------\n"+oldObj);		
		DBObject newObj= new BasicDBObject();
		newObj.putAll(oldObj);
		
	// preparing update	

		newObj.put("URL", "www.yahoo.com");
		newObj.put("Username", "Bill");
		newObj.put("Password", "Speiser");
		newObj.put("date", new Date());
        MongoLoginDAO.updateLogin(oldObj,newObj);
		searchQuery.put("StudentID", 2);
		
		System.out.println("Update----------\n"+newObj);		        
//verifying update		
		oldObj = MongoLoginDAO.getLogin(searchQuery);
		System.out.println("Read Update----------\n"+oldObj);	
if (true) return;
// Deleting		
		newObj = MongoLoginDAO.getLogin(searchQuery);		
		MongoLoginDAO.removeLogin(oldObj);

//verifying delete
		newObj = MongoLoginDAO.getLogin(searchQuery);		
		System.out.println("Confirm Delete-------\n"+ newObj);

		
	}



}
