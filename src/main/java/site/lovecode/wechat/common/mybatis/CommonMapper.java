package site.lovecode.wechat.common.mybatis;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Administrator on 2016/4/12.
 */
public interface CommonMapper<T> extends Mapper<T>, ReplaceMapper<T>, BatchMapper<T>, PageMapper<T> {}
