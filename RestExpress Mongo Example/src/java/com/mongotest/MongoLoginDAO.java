package com.mongotest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.util.List;
public class MongoLoginDAO {

	public static DBObject getLogin(DBObject searchQuery) throws Exception {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("test");
		DBCollection table = db.getCollection("test");
		DBCursor cursor = table.find(searchQuery);
		DBObject ret =null;
		while (cursor.hasNext()) {
			ret = cursor.next();
		}
	return ret;
	}
	public static List<DBObject> getLoginLogin(DBObject searchQuery) throws Exception {
		List<DBObject> ret =new ArrayList<DBObject>();
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("test");
		DBCollection table = db.getCollection("test");
		DBCursor cursor = table.find(searchQuery);
		//DBObject ret =null;
		while (cursor.hasNext()) {
			ret.add(cursor.next());
		}
	return ret;
	}
	public static void  insertLogin(DBObject  ret) throws Exception {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("test");
		DBCollection coll = db.getCollection("test");
		coll.insert(ret);
	}
	public static void  updateLogin(DBObject old, DBObject  update) throws Exception {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("test");
		DBCollection coll = db.getCollection("test");
		coll.findAndModify(old, update);
	}	
	
	public static void  removeLogin(DBObject  ret) throws Exception {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("test");
		DBCollection coll = db.getCollection("test");		
		coll.remove(ret);
	}	
	

	
}
