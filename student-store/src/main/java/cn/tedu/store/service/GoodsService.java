package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
@Service
public class GoodsService implements  IGoodsService{

	@Resource
	private GoodsMapper goodsMapper ;
	public List<Goods> getByCategoryId(Integer categoryId, Integer offset, Integer count) {
		return goodsMapper.selectByCategoryId(categoryId, offset, count);
	}
	//查询商品的数量
	public Integer getCount(Integer categoryId) {
		return goodsMapper.selectCount(categoryId);
	}
	//根据id查询商品信息
	public Goods getById(String id) {
		return  goodsMapper.selectById(id);
	}

}
