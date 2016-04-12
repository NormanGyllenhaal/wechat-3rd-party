package site.lovecode.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;

import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
public interface BatchMapper<T> {



    @InsertProvider(type=BatchProvider.class,method = "dynamicSQL")
    Integer batchInsert(List<T> recordList);


}
