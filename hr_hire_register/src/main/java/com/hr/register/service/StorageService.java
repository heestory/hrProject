package com.hr.register.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hr.register.domain.Images;
import com.hr.register.utils.Util;

@Service
public class StorageService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private Path uploadRootLocation;
	private Path imageRootLocation;
	private String fileName;
	
	public void init() {
		try {
			this.uploadRootLocation = Paths.get(Util.filePath("upload"));
			this.imageRootLocation = Paths.get(Util.filePath("images"));
			Files.createDirectories(uploadRootLocation);
			Files.createDirectories(imageRootLocation);
		}catch(IOException e) {
			throw new RuntimeException("Could not initialize storage");
		}
	}
	
	public void store(MultipartFile file) {
		try {
			fileName = file.getOriginalFilename();
			Files.copy(file.getInputStream(), this.uploadRootLocation.resolve(file.getOriginalFilename()));
		}catch(Exception e) {
			throw new RuntimeException("FAIL");
		}
	}
	
	 public String loadFile() {
		 try {
			 Path file = uploadRootLocation.resolve(fileName);
			 return file.toString();
		 }catch(Exception e) {
			 throw new RuntimeException("Get a filename fail");
		 }
	 }
	
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(uploadRootLocation.toFile());
		FileSystemUtils.deleteRecursively(imageRootLocation.toFile());
	}
	
	
	public List<Images> getImages() {
		
		File images = new File(this.imageRootLocation.toString());
		File[] imageList = images.listFiles();
		File imageName;
		List<Images> imageNameList= new ArrayList<>();
		
		
		for(int i = 0; i<imageList.length; i++) {
			Images imageObject = new Images();
			imageName = imageList[i];
			imageObject.setImageName(imageName.getName());
			imageObject.setSiteName(imageName.getName().replaceAll(".png", ""));
			imageNameList.add(imageObject);
			imageObject = null;
		}
		
		return imageNameList;
		
	}

}
