package site.lovecode.wechat.common.mybatis;


import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import site.lovecode.wechat.annotation.Batch;

import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
public interface BatchMapper<T> {


	@Batch
	@InsertProvider( type = BatchProvider.class, method = "dynamicSQL" )
	Integer batchInsert(List<T> recordList);


	@Batch
	@InsertProvider( type = BatchProvider.class, method = "dynamicSQL" )
	Integer batchInsertSelective(List<T> recordList);


	@Batch
	@UpdateProvider( type = BatchProvider.class, method = "dynamicSQL" )
	Integer batchUpdate(List<T> recordList);


	@Batch
	@UpdateProvider( type = BatchProvider.class, method = "dynamicSQL" )
	Integer batchUpdateSelective(List<T> recordList);


	@Batch
	@DeleteProvider( type = BatchProvider.class, method = "dynamicSQL" )
	Integer batchDelete(List<T> recoreList);
}
