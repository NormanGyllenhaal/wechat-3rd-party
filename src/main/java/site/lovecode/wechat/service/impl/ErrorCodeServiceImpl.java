/**
 * ErrorCodeServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.entity.ErrorCode;
import site.lovecode.wechat.mapper.ErrorCodeMapper;
import site.lovecode.wechat.service.IErrorCodeService;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;


/**
 * 
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月5日 
 * @version  1.0.0	 
 */
@Service
public class ErrorCodeServiceImpl implements IErrorCodeService {


	@Resource
	private ErrorCodeMapper errorCodeMapper;


	@Override
	public Page<ErrorCode> getErrorCodePage(Page<ErrorCode> page ) {
		//errorCodeMapper.selectPage(page);
		return page;
	}

}
