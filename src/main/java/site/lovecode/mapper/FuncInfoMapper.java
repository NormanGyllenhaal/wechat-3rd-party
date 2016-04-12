package site.lovecode.mapper;

import site.lovecode.entity.FuncInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FuncInfoMapper extends Mapper<FuncInfo> {

    public void batchInsert(List<FuncInfo> list);
}