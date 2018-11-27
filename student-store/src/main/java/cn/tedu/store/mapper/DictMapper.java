package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {

	//查询省份
	List<Province> selectProvince();
	//查询城市
	List<City> selectCity(String provinceCode);
	//根据城市标号查询区县
	List<Area> selectArea(String cityCode);
	
	//根据省的标号查询省的名称
	String selectByProvinceCode(String provinceCode);
	//根据城市标号查询城市名称
	String selectByCityCode(String cityCode);
	//根据区县标号查询区县名称
	String selectByAreaCode(String areaCode);
}
