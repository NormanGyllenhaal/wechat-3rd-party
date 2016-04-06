package site.lovecode.mapper;

import site.lovecode.entity.ComponentVerifyTicket;
import tk.mybatis.mapper.common.Mapper;

public interface ComponentVerifyTicketMapper extends Mapper<ComponentVerifyTicket> {

    public String selectOrderByCreateTime(String appid);

}