package com.hr.register.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Util {
	
	
	public static String filePath(String foldName) {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    String realPath = request.getSession().getServletContext().getRealPath("/");
	    File file = new File(realPath+"\\"+foldName);
	    if(!file.exists()) {
	    	file.mkdirs();
	    }
	    
	    return file.getAbsolutePath()+"\\";
	}
	
}
