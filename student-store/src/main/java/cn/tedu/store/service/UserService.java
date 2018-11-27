package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.exception.PasswordNotMatchException;
import cn.tedu.store.service.exception.UserNotFoundException;
import cn.tedu.store.service.exception.UsernameAlreadyException;

@Service
public class UserService implements IUserService {
/**
 * 添加用户信息
 */
	@Resource
	private UserMapper userMapper;
	//给成员变量赋值@Value()
	@Value("#{config.salt}")
	private String salt;
	public void addService(User user) {
		User user1=userMapper.selectByUsername(user.getUsername());
		
		if(user1==null){
			//获取页面文本框里的密码
			String pwd=user.getPassword();
			//生成的密码密文
			String md5Pwd=DigestUtils.md5Hex(pwd+salt);
			//把密文设置为user的password属性值
			user.setPassword(md5Pwd);
			
			userMapper.insertUser(user);
		}else{
			throw new UsernameAlreadyException("用户名已经存在");
		}
	}
	//根据邮箱判断,已经存在则返回true
	public boolean checkEmail(String email) {
		/*Integer n=userMapper.selectByEmail(email);
		if(n>0){
			return true;
		}else{
			return false;
		}*/ 
		
		return userMapper.selectByEmail(email)>0;
	} 
	/**
	 * 根据电话判断,已经存在则返回true
	 */
	public boolean checkPhone(String phone) {
		/*Integer n=userMapper.selectByPhone(phone);
		if(n>0){
			return true;
		}else{
			return false;
		}*/
		return userMapper.selectByPhone(phone)>0;
		
	}
	/**
	 * 根据用户名判断,已经存在则返回true
	 */
	public boolean checkUsename(String username) {
		return userMapper.selectByUsername(username)!=null;
	}
	//登入
	public User login(String username, String password) {
		System.out.println("業務");
		User user=userMapper.selectByUsername(username);
		if(user==null){
			throw new UserNotFoundException("用户未找到");
		}else{	
			System.out.println(user.getPassword());
			//
			String md5Pwd=DigestUtils.md5Hex(password+salt);
			
			
			if(user.getPassword().equals(md5Pwd)){
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}
	public User changepassword(Integer id, String oldPassword, String newPassword) {
		User user=userMapper.selectUserById(id);
		
		if(user!=null){
			//给密码加盐
			String md5Pwd=DigestUtils.md5Hex(oldPassword+salt);
			if(user.getPassword().equals(md5Pwd)){
				
				User user1=new User();
				user1.setId(id);
				//给密码加盐
				String md5Newpwd=DigestUtils.md5Hex(newPassword+salt);
				user1.setPassword(md5Newpwd);
				userMapper.updateUser(user1);
			}else{
				throw new PasswordNotMatchException("旧密码不匹配");
			}
		}else{
			throw new UserNotFoundException("用户不存在");
		}
		
		
		return user;
	}
	//个人信息修改
	public void updateUsers(Integer id, String username, Integer gender, String email, String phone) {
		User user1=userMapper.selectUserById(id);
		if(user1!=null){
			User user2=userMapper.selectByUsername(username);
			if(user2!=null && !user1.getUsername().equals(username)){
				throw new UsernameAlreadyException("用户名已存在");
			}else{
				User user=new User();
				user.setId(id);
				user.setUsername(username);
				user.setGender(gender);
				user.setEmail(email);
				user.setPhone(phone);
				userMapper.updateUser(user);
			}
		}else{
			throw new UserNotFoundException("用户不存在");
		}
	}
	//根据id查询个人信息
	public User getUserById(Integer id) {
		return  userMapper.selectUserById(id);
		
	}
	//修改头像
	public void changeImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
		
	}
	
}
