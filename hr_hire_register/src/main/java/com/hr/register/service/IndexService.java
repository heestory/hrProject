package com.hr.register.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hr.register.domain.InitList;
import com.hr.register.domain.Submit;
import com.hr.register.utils.NaverModule;

@Service
public class IndexService {
	
	private WebDriver driver; 
	
    @Value("${webdriver.window_chrome}")
    private String WEBDRIVER_CHROME_FILE_PATH;
    @Value("${webdriver.window_firefox}")
    private String WEBDRIVER_FIREFOX_FILE_PATH;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String filePath = "";
	
	public List<InitList> arrangeList(Map<Integer, InitList> initLists, Submit submit, String filePath) {
		
		List<InitList> resultList = new ArrayList<>();
		int listVal= 0;
		String[] lists = submit.getSubmitList().split(",");
		this.filePath = filePath;
		
		//체크된 항목 등록
		for(int i = 0; i<lists.length; i++) {
			listVal = Integer.parseInt(lists[i]);
			
			switch(listVal) {
				case 0: 
//					imageFileName = initLists.get(listVal).getSiteName();
					initLists.get(listVal).setResult(gimasa(submit));
					break;
				case 1: 
//					imageFileName = initLists.get(listVal).getSiteName();
					initLists.get(listVal).setResult(webmansa(submit));
					break;
			}
			initLists.get(listVal).setTotalResult(true);
		}
		
		//화면에 모든 항목을 보일 수 있도록 리스트에 삽입
		for(int k = 0; k<initLists.size(); k++) {
			resultList.add(initLists.get(k));
		}
		
		return resultList;
	}
	
	public boolean gimasa(Submit submit) {
		
		boolean result = false;
		
		try {
			System.setProperty("webdriver.chrome.driver", WEBDRIVER_CHROME_FILE_PATH);
			driver = new ChromeDriver();
			logger.info("=========================GIMASA START===================================");
			driver = NaverModule.naverModule(driver, "http://cafe.naver.com/newplanmarketing","menuLink69",submit,filePath,"gimasa");
			logger.info("=========================GIMASA END===================================");
			result = true;
		}catch(TimeoutException e){
			logger.error("============================================");
			logger.error("Not found button name:"+e);
			logger.error("============================================");
			result = false;
		}catch(Exception e) {
			logger.error("============================================");
			logger.error("ErrorOccur:"+e);
			logger.error("============================================");
			result = false;
		}
		finally {
			driver.quit();
		}
		
		return result;
	}
	
	public boolean webmansa(Submit submit) {
		
		boolean result = false;
		
		try {
			System.setProperty("webdriver.chrome.driver", WEBDRIVER_CHROME_FILE_PATH);
			driver = new ChromeDriver();
			logger.info("=========================WEBMANSA START===================================");
			driver = NaverModule.naverModule(driver, "http://cafe.naver.com/netmaru","menuLink20",submit,filePath,"webmansa");
			logger.info("=========================WEBMANSA END===================================");
			result = true;
		}catch(TimeoutException e){
			logger.error("============================================");
			logger.error("Not found button name:"+e);
			logger.error("============================================");
			result = false;
		}catch(Exception e) {
			logger.error("============================================");
			logger.error("ErrorOccur:"+e);
			logger.error("============================================");
			result = false;
		}
		finally {
			driver.quit();
		}
		
		return result;
	}
}
