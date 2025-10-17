package edu.xyf.wrench.dynamic.config.center.domain.service;

import edu.xyf.wrench.dynamic.config.center.domain.model.valobj.AttributeVO;

/**
 * @Author: Xuyifeng
 * @Description: 动态配置中心服务接口
 * @Date: 2025/10/17 15:19
 */

public interface IDynamicConfigCenterService {

    Object proxyObject(Object bean);

    /**
     * 调整属性值
     * @param attributeVO
     */
    void adjustAttributeValue(AttributeVO attributeVO);

}
