package site.lovecode.wechat.weixin;

import org.springframework.scheduling.annotation.Async;


/**
 * Created by Administrator on 2016/4/29.
 */
public class AsyncTest {

    public void testAsync(){
        try {
            Thread.sleep(5000);
            System.out.println("--------------------"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
