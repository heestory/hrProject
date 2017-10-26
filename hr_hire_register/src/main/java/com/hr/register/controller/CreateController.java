package com.hr.register.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hr.register.domain.InitList;
import com.hr.register.domain.Submit;
import com.hr.register.resource.Datas;
import com.hr.register.service.IndexService;
import com.hr.register.service.StorageService;

@RestController
@RequestMapping(value="/api2")
public class CreateController{
	
	@Autowired
	public IndexService indexService;
	
	@Autowired
	public StorageService storageService;
	
	
	List<String> files = new ArrayList<String>();
	
	@PostMapping(value="/create")
	public List<InitList> create(@RequestBody Submit submit, Object command){
		
		String filePath = storageService.loadFile();
		
		List<InitList> InitList = indexService.arrangeList(Datas.initLists, submit, filePath);
		return InitList;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> handlerFileUpload(@RequestParam("file")MultipartFile file){
		String message = "";
		
		try {
			storageService.store(file);
			files.add(file.getOriginalFilename());
			
			message = "Success upload" + file.getOriginalFilename()+"!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		}catch(Exception e) {
			message = "Fail to upload" + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	} 
	
	@GetMapping(value="/delete")
	public String deleteCustomer(){
		storageService.deleteAll();
		
		//초기화면 값들 초기화
		for(int i = 0; i<Datas.initLists.size(); i++) {
			Datas.initLists.get(i).setResult(false);
		}
		
		return "redirect:/index";
	}

}
