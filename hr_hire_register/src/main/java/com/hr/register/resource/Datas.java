package com.hr.register.resource;

import java.util.HashMap;
import java.util.Map;

import com.hr.register.domain.InitList;
import com.hr.register.utils.UrlConnectionCheck;

public class Datas {
	
	static UrlConnectionCheck conInstance = UrlConnectionCheck.getInstance();
	
	public static Map<Integer, InitList> initLists = new HashMap<Integer, InitList>(){
		{
//			put(1, new InitList("DBCUT",1,conInstance.getConnectionResult("https://www.dbcu.com/bbs/bbs.php?table=job"),false));
			put(0, new InitList("GIMASA",0,conInstance.getConnectionResult("http://cafe.naver.com/newplanmarketing"),false));
			put(1, new InitList("WebManSa",1,conInstance.getConnectionResult("http://cafe.naver.com/netmaru"),false));
		}
	};
}
