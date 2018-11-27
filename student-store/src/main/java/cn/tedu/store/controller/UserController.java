package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
 
	@Resource
	private IUserService userService;
	//显示注册页面
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	//异步验证用户名
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr=null;
		boolean b=userService.checkUsename(username);
		if(b){
			rr=new ResponseResult<Void>(0,"用户名已存在");
		}else{
			rr=new ResponseResult<Void>(1,"用户名可以使用");
		}
		
		return rr;
	}
	//异步验证邮箱
	@RequestMapping("/checkUseremail.do")
	@ResponseBody
	public ResponseResult<Void> checkUseremail(String email){
		ResponseResult<Void> rr=null;
		boolean b=userService.checkEmail(email);
		if(b){
			rr=new ResponseResult<Void>(0,"邮箱已存在");
		}else{
			rr=new ResponseResult<Void>(1,"邮箱可以使用");
		}
		return rr;
	}
	//异步验证电话号码
	@RequestMapping("/checkUserphone.do")
	@ResponseBody
	public ResponseResult<Void> checkUserphone(String phone){
		ResponseResult<Void> rr=null;
		boolean b=userService.checkPhone(phone);
		if(b){
			rr=new ResponseResult<Void>(0,"电话号码已使用");
		}else{
			rr=new ResponseResult<Void>(1,"电话号码可以使用");
		}
		return rr;
	}
	//异步提交注册功能
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("uname") String username,
			@RequestParam("upwd") String password,
			String email,String phone){
			ResponseResult<Void> rr=null;
			try{
				User user=new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setPhone(phone);
				userService.addService(user);
				 
				rr=new ResponseResult<Void>(1,"添加数据成功");
				
			}catch(RuntimeException e){
				rr=new ResponseResult<Void>(0,e.getMessage());
			}
		return rr;
		
	}
	//显示登录页面
	@RequestMapping("/showlogin.do")
	public String showloginlogin(){
		return "login";
	}
	//异步提交登录
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr=null;
		try{
			User user=userService.login(username, password);
			rr=new ResponseResult<Void>(1,"登录成功");
			session.setAttribute("user", user);
			
		}catch(RuntimeException e){
			rr=new ResponseResult<Void>(0,e.getMessage());
			
		}
		return rr;
	}
	//退出登录
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:../main/showindex.do";
		
	}
	//显示修改密码 页面
	@RequestMapping("/showpassword.do")
	public String showpassword(){
		return "personal_password";
	}
	//修改密码
	@RequestMapping("/updatapassword.do")
	@ResponseBody
	public ResponseResult<Void>  updatapassword(HttpSession session,String oldPassword,String newPassword){
		ResponseResult<Void> rr=null;
		try{
			
			userService.changepassword(this.getId(session), oldPassword, newPassword);
			rr=new ResponseResult<Void>(1,"密码修改成功");
		}catch(RuntimeException e){
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	
	}
	//显示个人信息页面
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage(){
		return "personpage";
		
	}
	//修改个人信息
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,Integer gender,
			String email,String phone){
		ResponseResult<Void> rr=null;
		try{
			userService.updateUsers(this.getId(session), username, gender, email, phone);
			rr=new ResponseResult<Void>(1,"修改成功");
			User user=new User();
			user=userService.getUserById(this.getId(session));
			session.setAttribute("user", user);
		}catch(RuntimeException e){
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	//异步请求上传头像图片
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,HttpSession session) throws Exception, Exception{
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"修改成功");
		//1.上传图片
		//获取该项目的真实路径
		String path=session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		//2.修改数据库image 字段
		userService.changeImage(this.getId(session), "/upload/"+file.getOriginalFilename());
		return rr;
		
	}
	
}
