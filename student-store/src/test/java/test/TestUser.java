package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserService;

public class TestUser {

	//持久层插入
	@Test
	public void testInsertUser(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setUsername("deftes");
		user.setPassword("66666666");
		user.setPhone("18700000000");
		user.setEmail("deft@163.com");
		us.insertUser(user);
		ac.close();
	}
	//持久层 查找
	@Test
	public void  testSelectUser(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		System.out.println(us.selectByUsername("小黑"));
		ac.close();
	}
	//持久层 查找
	@Test
	public void testSelectAll(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		List<User> list=us.selectAll();
		for(User ls:list){
			System.out.println(ls);
		}
		ac.close();
	}
	//业务层添加
	@Test
	public void testAddUser(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		User user=new User();
		user.setUsername("rngedgrw");
		user.setPassword("741741");
		user.setPhone("12345678912");
		user.setEmail("uzi@.cn");
		user.setGender(0);
		us.addService(user);
		ac.close();
	}
	//持久层根据邮箱查找
	@Test
	public void testSelectEmail(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		System.out.println(us.selectByEmail("tedu@.cn"));
		ac.close();
	}
	//持久层 根据电话查找
	@Test
	public void testSelectPhone(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		System.out.println(us.selectByPhone("1234567890"));
		ac.close();
	}
	//业务层根据邮箱查找
	@Test
	public void testSelectEmails(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		System.out.println(us.checkEmail("tedu@.cn"));
		ac.close();
		
	}
	//业务层 根据电话查找
	@Test
	public void testSelectPhones(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		System.out.println(us.checkPhone("1234567890"));
		ac.close();
	}
	//业务层 根据用户名查找
	@Test
	public void testCheckUsername(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		System.out.println(us.checkUsename("大时代"));
		ac.close();
	}
	@Test
	public void testlogin(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",IUserService.class);
		User user=us.login("dashidai","777777");
		System.out.println(user);
		ac.close();
	}
	@Test
	public void testupdate(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setId(2);
		//user.setPassword("000000");
		user.setUsername("zhanshan");
		user.setGender(0);
		user.setPhone("12312312");
		user.setEmail("zhansan@qq.com");
 		us.updateUser(user);
		ac.close();
	}
	@Test
	public void testSelectUserById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		System.out.println(us.selectUserById(1));
		ac.close();
	}
	@Test
	public void testchangepassword(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",UserService.class);
		us.changepassword(1, "333333", "111222");
		ac.close();
	}
	//修改个人信息
	@Test
	public void testupdateUser(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IUserService us=ac.getBean("userService",UserService.class);
		us.updateUsers(1, "changes", 0, "change@qq.com", "13800138000");
		ac.close();
		
	}
	//修改头像
	@Test
	public void testUpdateImage(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		UserMapper us=ac.getBean("userMapper",UserMapper.class);
		us.updateImage(1, "烈焰");
		ac.close();
	}
}
