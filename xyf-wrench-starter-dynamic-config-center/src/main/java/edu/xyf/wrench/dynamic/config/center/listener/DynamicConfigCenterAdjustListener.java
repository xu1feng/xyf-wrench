package edu.xyf.wrench.dynamic.config.center.listener;

import edu.xyf.wrench.dynamic.config.center.domain.model.valobj.AttributeVO;
import edu.xyf.wrench.dynamic.config.center.domain.service.IDynamicConfigCenterService;
import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/17 15:42
 */

public class DynamicConfigCenterAdjustListener implements MessageListener<AttributeVO> {

    private final Logger log = LoggerFactory.getLogger(DynamicConfigCenterAdjustListener.class);

    private final IDynamicConfigCenterService dynamicConfigCenterService;

    public DynamicConfigCenterAdjustListener(IDynamicConfigCenterService dynamicConfigCenterService) {
        this.dynamicConfigCenterService = dynamicConfigCenterService;
    }

    @Override
    public void onMessage(CharSequence charSequence, AttributeVO attributeVO) {
        try {
            log.info("xyf-wrench dcc config attribute:{} value:{}", attributeVO.getAttribute(), attributeVO.getValue());
            dynamicConfigCenterService.adjustAttributeValue(attributeVO);
        } catch (Exception e) {
            log.error("xyf-wrench dcc config attribute:{} value:{}", attributeVO.getAttribute(), attributeVO.getValue(), e);
        }
    }

}
