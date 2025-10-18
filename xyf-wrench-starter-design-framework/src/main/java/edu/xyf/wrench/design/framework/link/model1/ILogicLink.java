package edu.xyf.wrench.design.framework.link.model1;

/**
 * @Author: Xuyifeng
 * @Description: 略规则责任链接口
 * @Date: 2025/10/18 14:48
 */

public interface ILogicLink<T, D, R> extends ILogicChainArmory<T, D, R> {

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
