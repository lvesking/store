package test;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.DictService;
import cn.tedu.store.service.IAddressService;

public class TestAddress {

	//插入信息
	@Test
	public void testInsert(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		AddressMapper add=ac.getBean("addressMapper",AddressMapper.class);
		Address ad=new Address();
		ad.setUid(6);
		ad.setRecvName("张三");
		ad.setRecvProvince("东北");
		ad.setRecvCity("哈尔滨");
		ad.setRecvArea("东北虎");
		ad.setRecvDistrict("深山里的松树下");
		ad.setRecvAddress("深山里");
		ad.setRecvPhone("666");
		ad.setRecvTel("999");
		ad.setRecvZip("000");
		ad.setRecvTag("不知道");
		ad.setIsDefault(1);
		add.insertAddress(ad);
		ac.close();
	}
	//根据收货人id查询收货人详细信息 
	@Test
	public void testselectByUid(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		AddressMapper add=ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(add.selectByUid(12));
		ac.close();
		
	}
	@Test
	public void testAddress(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		Address address=new Address();
		address.setUid(11);
		address.setRecvName("大豆");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvAddress("长白山");
		address.setRecvPhone("333333");
		address.setRecvTel("32646");
		address.setRecvTag("公司");
		as.addAddress(address);
		ac.close();
	}
	
	@Test
	public void testupdateByUid(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		AddressMapper add=ac.getBean("addressMapper",AddressMapper.class);
		add.updateByUid(2);
		add.updateById(11);
		ac.close();
	}
	@Test
	public void testupdata(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		as.setDefault(1, 8);
		ac.close();
	}
	@Test
	public void testupdateById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		AddressMapper add=ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(add.selectById(1));
		ac.close();
	}
	@Test
	public void testUpdateAddressById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		AddressMapper add=ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setId(1);
		address.setRecvName("你猜把");
		address.setRecvProvince("360000");
		address.setRecvCity("360700");
		address.setRecvArea("360730");
		address.setRecvDistrict("江西省赣州市宁都县");
		address.setRecvAddress("asdf");
		address.setRecvPhone("587");
		address.setRecvTel("684");
		address.setRecvZip("55");
		address.setRecvTag("家");
		add.updateAddressById(address);
		ac.close();
	}
	@Test
	public void testDeleteAddress(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IAddressService as=ac.getBean("addressService",IAddressService.class);
		as.removeAddress(10);
		ac.close();
	}
}
