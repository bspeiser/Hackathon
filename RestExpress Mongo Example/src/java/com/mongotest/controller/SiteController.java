package com.mongotest.controller;

import java.util.Map;

import org.jboss.netty.buffer.ChannelBuffer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongotest.MongoLoginDAO;
import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;
import org.bson.BSONObject;
import java.util.List;
import java.util.ArrayList;

/**
 * @author toddf
 * @since Aug 31, 2010
 */
public class SiteController
extends AbstractDelayingController
{
    private static final String ECHO_PARAMETER_NOT_FOUND = "'echo' header or query-string parameter not found";
	private static final String ECHO_HEADER = "echo";

	public ChannelBuffer create(Request request, Response response)
	{
	//	String sb = bodyToString (request.getBody());

		//System.out.println("Posting:"+sb);
		Map m = request.getQueryStringMap();
		//Map m = request.getBodyFromUrlFormEncoded();
		System.out.println("Posting:"+m);
		BasicDBObject bs = new BasicDBObject(m);
		bs.putAll(m);
//		com.mongodb.util.Util.
//		DBObject
//		Object o = com.mongodb.util.JSON.parse(m);
//		DBObject dbObj = (DBObject) o;
		try {
			MongoLoginDAO.insertLogin(bs);						
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setResponseCreated();
		return request.getBody();
	}

	
	public String delete(Request request, Response response)
	{
		delay(request);
		String sb = bodyToString (request.getBody());

		System.out.println("Posting:"+sb);
		Object o = com.mongodb.util.JSON.parse(sb.toString());
		DBObject dbObj = (DBObject) o;
		try {
			MongoLoginDAO.removeLogin(dbObj);						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return request.getUrlDecodedHeader("Deleted");
	}
	
	public String read(Request request, Response response)
	{
		System.out.println("read:"+request.getRawHeader("site"));
		String ret =request.getRawHeader("site");
//		delay(request);
//        String sb2 = (String)request.getParameter("q");
//        String ret = "Not Found";
//		System.out.println("Posting:"+sb2);
		Object o = com.mongodb.util.JSON.parse("{SiteId:"+ret+"}");
		DBObject dbObj = (DBObject) o;
		try {
			DBObject reto = MongoLoginDAO.getLogin(dbObj);
			if (reto!=null)  ret = reto.toString();						
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setResponseCreated();
		return ret;
	}
	public List readAll(Request request, Response response)
	{
//		delay(request);
//        String sb2 = (String)request.getParameter("q");
          List ret = new ArrayList();
//		System.out.println("Posting:"+sb2);
		try {
			DBObject reto = MongoLoginDAO.getLogin(null);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setResponseCreated();
		return ret;
	}


	public String bodyToString(ChannelBuffer cb){
		StringBuffer sb = new StringBuffer();
		 while (cb.readable()) {
		     sb.append(((char)cb.readByte()));
		 }
		 return  sb.toString();
		
	}

	public ChannelBuffer update(Request request, Response response)
	{
		delay(request);
		System.out.println("update:");
		return request.getBody();
	}
}
