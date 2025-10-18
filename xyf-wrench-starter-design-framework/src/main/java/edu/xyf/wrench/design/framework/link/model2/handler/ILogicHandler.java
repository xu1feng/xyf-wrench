package edu.xyf.wrench.design.framework.link.model2.handler;

/**
 * @Author: Xuyifeng
 * @Description: 逻辑处理器
 * @Date: 2025/10/18 14:53
 */

public interface ILogicHandler<T, D, R> {

    default R next(T requestParameter, D dynamicContext) {
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
