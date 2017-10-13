package com.hr.register.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TakeSnapShot {
	
	public static void takeShot(WebDriver webdriver, String fileName) throws Exception{
		
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    String realPath = request.getSession().getServletContext().getRealPath("/");
	    File file = new File(realPath+"\\images");
	    if(!file.exists()) {
	    	file.mkdirs();
	    }
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(file.getAbsolutePath()+"\\"+fileName+".png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
		
	}

}
