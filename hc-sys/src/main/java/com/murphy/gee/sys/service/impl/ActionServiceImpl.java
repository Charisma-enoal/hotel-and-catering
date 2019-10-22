package com.murphy.gee.sys.service.impl;

import com.murphy.gee.sys.entity.*;
import com.murphy.gee.sys.mapper.ActionMapper;
import com.murphy.gee.sys.mapper.AuthorityActionMapper;
import com.murphy.gee.sys.mapper.AuthorityMapper;
import com.murphy.gee.sys.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ActionServiceImpl
 * @Description 操作权限实现
 * @Author Murphy.Gee
 * @Date 2019-10-08 14:51
 * @Version 1.0
 **/
@Service("actionService")
public class ActionServiceImpl implements IActionService {
    @Autowired
    ActionMapper actionMapper;
    @Autowired
    AuthorityMapper authorityMapper;
    @Autowired
    AuthorityActionMapper authorityActionMapper;

    /*
     * @description: 操作权限保存
     * @param action
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 14:51
     */
    @Override
    public void save(Action action) {
        if (null != action.getActionId()){
            actionMapper.updateByPrimaryKey(action);
        }else{
            Integer actionKey = actionMapper.insert(action);
            Authority authority = new Authority();
            authority.setAuthType("3");
            Integer key = authorityMapper.insert(authority);
            AuthorityAction authorityAction = new AuthorityAction();
            authorityAction.setActionId(actionKey.longValue());
            authorityAction.setAuthId(key.longValue());
            authorityActionMapper.insert(authorityAction);
        }
    }
    /*
     * @description: 查看
     * @param actionId
     * @return: com.murphy.gee.sys.entity.Action
     * @author: Murphy.Gee
     * @date: 2019-10-08 15:20
     */
    @Override
    public Action view(Long actionId) {
        return actionMapper.selectByPrimaryKey(actionId);
    }
    /*
     * @description: 删除
     * @param actionId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 16:03
     */
    @Override
    public void delete(Long actionId) {
        ActionExample actionExample = new ActionExample();
        actionExample.createCriteria().andActionIdEqualTo(actionId);
        actionMapper.deleteByExample(actionExample);

        //查询出authId
        AuthorityActionExample authorityActionExample = new AuthorityActionExample();
        authorityActionExample.createCriteria().andActionIdEqualTo(actionId);
        List<AuthorityAction> list = authorityActionMapper.selectByExample(authorityActionExample);
        Long authId = new Long(0);
        if (null != list && list.size() > 0){
            authId = list.get(0).getAuthId();
        }

        //删除关联关系表
        authorityActionMapper.deleteByExample(authorityActionExample);

        //删除auth对应的数据
        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andAuthIdEqualTo(authId);
        authorityMapper.deleteByExample(authorityExample);
    }
}
