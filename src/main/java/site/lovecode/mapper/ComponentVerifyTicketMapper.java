package site.lovecode.mapper;

import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.ComponentVerifyTicket;

public interface ComponentVerifyTicketMapper extends CommonMapper<ComponentVerifyTicket> {

    ComponentVerifyTicket selectOrderByCreateTime(String componentAppId);
}