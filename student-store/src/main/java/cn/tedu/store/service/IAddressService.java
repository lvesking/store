package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
//@Transactional:表示接口的所有实现类都有实现事务
@Transactional
public interface IAddressService {

	void addAddress(Address address);
	List<Address> getByUid(Integer uid);
	void setDefault(Integer uid,Integer id);
	Address getById(Integer id);
	//修改收货人地址
	void updateAddress(Address address);
	//删除收货人地址
	void removeAddress(Integer id);
}
