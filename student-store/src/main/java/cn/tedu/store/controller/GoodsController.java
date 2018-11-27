package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Resource
	private IGoodsService goodsService;
	//显示笔记本展示页面
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map){
		//三级分类的点击事件
		if(page==null){
			page=1;
		}
		//通过page计算出跳过的条数offset的值
		Integer offset=(page-1)*12;
		//获取每一页商品的集合
		List<Goods> list=goodsService.getByCategoryId(categoryId,offset,12);
		//获取商品的数量
		Integer count=goodsService.getCount(categoryId);
		//共显示多少页
		int pageSize=count%12==0?count/12:count/12+1;
		//把集合添加到map集合中
		map.addAttribute("list",list);
		map.addAttribute("count",count);
		map.addAttribute("pageSize",pageSize);
		map.addAttribute("categoryId", categoryId);
		//当前页
		map.addAttribute("curpage", page);
		return "search";
	}
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(String id,ModelMap map){
		
		Goods goods=goodsService.getById(id);
		map.addAttribute("goods", goods);
		
		return "product_details";
		
	}
}

