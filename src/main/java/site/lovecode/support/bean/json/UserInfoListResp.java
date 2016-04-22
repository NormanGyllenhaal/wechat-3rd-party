package site.lovecode.support.bean.json;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/21.
 */
public class UserInfoListResp implements Serializable {

    @JSONField(name="user_info_list")
    private List<UserInfoResp> list;

    public List<UserInfoResp> getList() {
        return list;
    }

    public void setList(List<UserInfoResp> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "UserInfoListResp{" +
                "list=" + list +
                '}';
    }
}
