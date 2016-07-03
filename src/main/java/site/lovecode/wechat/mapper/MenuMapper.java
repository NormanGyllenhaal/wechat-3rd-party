package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.MenuDto;
import site.lovecode.wechat.dto.MenuMediaDto;
import site.lovecode.wechat.entity.Menu;

public interface MenuMapper extends CommonMapper<Menu> {


	/**
	 * 查询一二级菜单列表
	 * 
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @return
	 */
	MenuDto selectMenuJoinSelf(@Param("oaid") Long oaid);


	/**
	 * 
	 * 根据菜单id查询菜单设置
	 * <p>
	 * 
	 *
	 * @param menuId
	 * @return
	 */
	MenuMediaDto selectJoinMedia(@Param("menuId") Long menuId);
}
