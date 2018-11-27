package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {

	//插入信息
	void insertAddress(Address address);
	//根据收货人id查询收货人
	List<Address> selectByUid(Integer uid);
	//把所有的地址isDifault设置为0,
	Integer updateByUid(Integer uid);
	//把指定的isDifault设置为1
	Integer updateById(Integer id);
	Address selectById(Integer id);
	
	void updateAddressById(Address address);
	//删除收货人地址
	void deleteById(Integer id);
}
