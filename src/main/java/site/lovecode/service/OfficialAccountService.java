package site.lovecode.service;

import site.lovecode.entity.OfficialAccount;
import site.lovecode.support.bean.request.OfficialAccountReq;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public interface OfficialAccountService {

    void saveOfficialAccount(OfficialAccountReq officialAccountReq);


    List<OfficialAccount> getAllOfficialAccount();
}
