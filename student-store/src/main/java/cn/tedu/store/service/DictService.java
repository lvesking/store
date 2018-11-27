package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
@Service
public class DictService implements IDictService {

	@Resource
	private DictMapper dictMapper;
	//查询所有省份
	public List<Province> getProvince() {
		return dictMapper.selectProvince();
	}
	//根据省份标号查询城市
	public List<City> getCity(String provinceCode) {
		return dictMapper.selectCity(provinceCode);
	}
	//根据城市编号查询区县
	public List<Area> getArea(String cityCode) {
		return dictMapper.selectArea(cityCode);
	}
	

}
