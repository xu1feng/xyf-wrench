package edu.xyf.wrench.design.framework.link.model1;

/**
 * @Author: Xuyifeng
 * @Description: 责任链装配
 * @Date: 2025/10/18 14:48
 */

public interface ILogicChainArmory<T, D, R> {

    ILogicLink<T, D, R> next();

    ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next);

}
