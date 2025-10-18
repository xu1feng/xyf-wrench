package edu.xyf.wrench.test.design.framework.biz.tree.node;

import edu.xyf.wrench.design.framework.tree.StrategyHandler;
import edu.xyf.wrench.test.design.framework.biz.tree.AbstractXxxSupport;
import edu.xyf.wrench.test.design.framework.biz.tree.factory.DefaultStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/18 15:09
 */

@Slf4j
@Component
public class SwitchRoot extends AbstractXxxSupport {

    @Autowired
    private AccountNode accountNode;

    @Override
    protected String doApply(String requestParameter, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("【开关节点】规则决策树 userId:{}", requestParameter);
        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<String, DefaultStrategyFactory.DynamicContext, String> get(String requestParameter, DefaultStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return accountNode;
    }

}
