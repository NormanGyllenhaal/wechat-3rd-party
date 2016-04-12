package site.lovecode.common.mybatis;

import site.lovecode.entity.AuthorizerInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * Created by Administrator on 2016/4/12.
 */
public interface MyMapper<T> extends Mapper<T>,ReplaceMapper<T>,BatchMapper<T>{
}
