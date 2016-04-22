package site.lovecode.support.bean.headler;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.entity.ErrorCode;
import site.lovecode.mapper.ErrorCodeMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Resource
    private ErrorCodeMapper errorCodeMapper;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<>();
        if(ex instanceof WxErrorException){
            WxErrorException errorException = (WxErrorException) ex;
            ErrorCode errorCode = errorCodeMapper.selectOne(new ErrorCode(){
                {
                    setCode(String.valueOf(errorException.getError().getErrorCode()));
                }
            });
            model.put("msg",errorCode.getMsg());
        }else{
            model.put("ex",ex);
        }
        logger.error("异常信息",ex);
        return new ModelAndView("error",model);
    }
}
