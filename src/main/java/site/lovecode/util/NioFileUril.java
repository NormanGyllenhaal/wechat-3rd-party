package site.lovecode.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import site.lovecode.entity.ErrorCode;
import site.lovecode.mapper.ErrorCodeMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
public class NioFileUril {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/微信/errorCode.txt"));
        Map<String,String> map = new HashMap<>();
        Integer count = 0;
        String code  =  null;
        String str;
        while((str=bufferedReader.readLine()) != null){
            count++;
            System.out.println(str);
            if(count%2==0){
                map.put(code,str);
            }else{
                code = str;
            }
        }
        System.out.print(count);
        System.out.println(map.toString());
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:applicationContext-*.xml");
        ErrorCodeMapper errorCodeMapper = (ErrorCodeMapper) ctx.getBean("errorCodeMapper");
        List<ErrorCode> list  = new ArrayList<>();
        map.forEach((s, s2) -> list.add(new ErrorCode(){
            {
                setId(IdWorker.getId());
                setCode(s);
                setMsg(s2);
            }
        })
        );
        errorCodeMapper.batchInsert(list);
    }
}
