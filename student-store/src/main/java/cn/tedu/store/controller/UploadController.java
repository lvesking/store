package cn.tedu.store.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	//1.显示上传的表单
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
		
	}
	//2.实现上传文件的功能
	@RequestMapping("/uploadFile.do")
	public String uploadFile(MultipartFile file) throws IllegalStateException, Exception{
		//1.实现上传功能,存储图片的地址
		file.transferTo(new File("E:/公仔",file.getOriginalFilename()));
		//2.响应页面
		return "redirect:../main/showindex.do";
		
	}
	
	
}
