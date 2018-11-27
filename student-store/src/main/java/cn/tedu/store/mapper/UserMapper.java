package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {

	/**
	 * 持久层添加用户
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 持久层 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	User selectByUsername(String username);
	/**
	 * 持久层 查找所有
	 * @return
	 */
	List<User> selectAll();
	/**
	 * 持久层 根据邮箱,电话查询
	 * @param email
	 * @return
	 */
	Integer selectByEmail(String email);
	Integer selectByPhone(String phone);
	//用户信息修改
	void updateUser(User user);
	//根据用户id查询
	User selectUserById (Integer id);
	//修改头像
	void updateImage(@Param("id") Integer id,@Param("image") String image);
	
	
	
	
	
	
	
	
	
}
