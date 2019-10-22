package com.murphy.gee.sys.service;

import com.murphy.gee.sys.entity.Action;
import org.springframework.transaction.annotation.Transactional;

public interface IActionService {
    /*
     * @description: 新增操作权限
     * @param action
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 14:51
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void save(Action action);

    /*
     * @description: 查看
     * @param actionId
     * @return: com.murphy.gee.sys.entity.Action
     * @author: Murphy.Gee
     * @date: 2019-10-08 15:20
     */
    Action view(Long actionId);

    /*
     * @description: 删除
     * @param actionId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 16:03
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void delete(Long actionId);
}
