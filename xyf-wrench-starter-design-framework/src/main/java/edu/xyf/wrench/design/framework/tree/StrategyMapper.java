package edu.xyf.wrench.design.framework.tree;

/**
 * @Author: Xuyifeng
 * @Description: 策略映射器
 * T 入参类型
 * D 上下文类型
 * R 返参类型
 * @Date: 2025/10/18 14:20
 */

public interface StrategyMapper<T, D, R> {

    /**
     * 获取待执行策略
     *
     * @param requestParameter 入参
     * @param dynamicContext   上下文
     * @return 返参
     * @throws Exception 异常
     */
    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;

}
