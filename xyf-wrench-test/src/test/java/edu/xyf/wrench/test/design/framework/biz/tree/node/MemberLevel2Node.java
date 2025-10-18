package edu.xyf.wrench.test.design.framework.biz.tree.node;

import com.alibaba.fastjson.JSON;
import edu.xyf.wrench.design.framework.tree.StrategyHandler;
import edu.xyf.wrench.test.design.framework.biz.tree.AbstractXxxSupport;
import edu.xyf.wrench.test.design.framework.biz.tree.factory.DefaultStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/18 15:09
 */

@Slf4j
@Component
public class MemberLevel2Node extends AbstractXxxSupport {

    @Override
    protected String doApply(String requestParameter, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("【级别节点-2】规则决策树 userId:{}", requestParameter);
        return "level2" + JSON.toJSONString(dynamicContext);
    }

    @Override
    public StrategyHandler<String, DefaultStrategyFactory.DynamicContext, String> get(String requestParameter, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }

}
