package edu.xyf.wrench.test.design.framework.biz.tree;

import edu.xyf.wrench.design.framework.tree.AbstractMultiThreadStrategyRouter;
import edu.xyf.wrench.test.design.framework.biz.tree.factory.DefaultStrategyFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/18 15:11
 */

public abstract class AbstractXxxSupport extends AbstractMultiThreadStrategyRouter<String, DefaultStrategyFactory.DynamicContext, String> {

    @Override
    protected void multiThread(String requestParameter, DefaultStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
        // 缺省的方法
    }

}
