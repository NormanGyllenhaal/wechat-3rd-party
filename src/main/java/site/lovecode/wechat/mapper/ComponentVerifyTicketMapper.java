package site.lovecode.wechat.mapper;


import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.entity.ComponentVerifyTicket;

public interface ComponentVerifyTicketMapper extends CommonMapper<ComponentVerifyTicket> {


	ComponentVerifyTicket selectOrderByCreateTime(String componentAppId);
}
