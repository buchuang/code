package com.nyist.microserviceconsumermovie.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController {

	@RequestMapping("/fileupload")
	public Object fileUpload(@RequestParam(value="file",required=true ) MultipartFile file) throws IllegalStateException, IOException{
		File saveFile=new File("D://"+file.getOriginalFilename());
		file.transferTo(saveFile);
		
		return saveFile.getAbsolutePath();
	}
}
