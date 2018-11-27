package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {

	/**
	 * mybatis如果参数多余一个,那么需要做处理,
	 * 1,把参数封装成类型
	 * 2.通过@Param 注解分别给变量映射
	 */
	List<GoodsCategory> selectByParentId(
			@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
}
