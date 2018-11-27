package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {

	/**
	 * 业务层添加信息
	 * @param user
	 */
	void addService(User user);
	
	boolean checkEmail(String email);
	boolean checkPhone(String phone);
	
	boolean checkUsename(String username);
	//实现登录,登入成功返回user对象,否则抛出用户名未找到或者密码错误
	User login(String username,String password);
	//用户信息修改
	User changepassword(Integer id,String oldPassword,String newPassword);
	//修改用户信息
	void updateUsers(Integer id,String username,Integer gender,String email,String phone);
	//根据id查询
	User getUserById(Integer id);
	//修改头像
	void changeImage(Integer id,String image);
	
	
	
	
}
