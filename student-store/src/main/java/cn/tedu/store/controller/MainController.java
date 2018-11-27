package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource IGoodsService goodsService;
		//显示首页
		@RequestMapping("/showindex.do")
		public String showindes(ModelMap map){
			List<List<GoodsCategory>> list3=new ArrayList<List<GoodsCategory>>();
			List<GoodsCategory> list2=goodsCategoryService.getByParentId(161, 0, 3);
			for(GoodsCategory li:list2){
				Integer ls=li.getId();
				List<GoodsCategory> lt=goodsCategoryService.getByParentId(ls, null, null);
				list3.add(lt);
			}
			//获取热卖商品的集合
			List<Goods> goodList=goodsService.getByCategoryId(163,0,3 );
			map.addAttribute("list2",list2);
			map.addAttribute("list3",list3);
			//把热卖商品的集合添加到map中
			map.addAttribute(goodList);
			
			return "index";
		}
		
		
		
}
