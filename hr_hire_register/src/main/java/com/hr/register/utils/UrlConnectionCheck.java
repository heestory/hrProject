package com.hr.register.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UrlConnectionCheck {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public UrlConnectionCheck() {
	}
	
	public static UrlConnectionCheck getInstance() {
		return new UrlConnectionCheck();
	}
	
	public String getConnectionResult(String siteUrl) {
		
		String result = "";
		HttpURLConnection conn = null;
		
		try {
			URL url = new URL(siteUrl);
			conn =(HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			
			result = Integer.toString(conn.getResponseCode());
			
		}catch(MalformedURLException e) {
			logger.error("================MalformedUrlException===================");
			logger.error(e.getMessage());
			result = "404";
			logger.error("========================================================");
		}catch(IOException e) {
			logger.error("================IOException=============================");
			logger.error(e.getMessage());
			result = "404";
			logger.error("========================================================");
		}finally {
			conn.disconnect();
		}
		
		return result;
	}
	
}
