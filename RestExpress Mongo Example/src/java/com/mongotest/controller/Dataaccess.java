package com.mongotest.controller;

import org.jboss.netty.buffer.ChannelBuffer;

import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;

/**
 * @author toddf
 * @since Aug 31, 2010
 */
public class Dataaccess
extends AbstractDelayingController
{
    private static final String DATAACCESS_PARAMETER_NOT_FOUND = "'dataaccess' header or query-string parameter not found";
	private static final String DATAACCESS_HEADER = "dataaccess";

	public ChannelBuffer create(Request request, Response response)
	{
		delay(request);
		response.setResponseCreated();
		return request.getBody();
	}
	
	public String delete(Request request, Response response)
	{
		delay(request);
		return request.getUrlDecodedHeader(DATAACCESS_HEADER, DATAACCESS_PARAMETER_NOT_FOUND);
	}
	
	public String read(Request request, Response response)
	{
		delay(request);
		String echo = request.getUrlDecodedHeader(DATAACCESS_HEADER);
		
		if (echo == null)
		{
			return "Please set query-string parameter 'dataaccess' (e.g. ?dataaccess=value)";
		}
		
		return echo;
	}

	public ChannelBuffer update(Request request, Response response)
	{
		delay(request);
		return request.getBody();
	}
}
