package edu.xyf.wrench.design.framework.link.model2;

import edu.xyf.wrench.design.framework.link.model2.chain.BusinessLinkedList;
import edu.xyf.wrench.design.framework.link.model2.chain.LinkedList;
import edu.xyf.wrench.design.framework.link.model2.handler.ILogicHandler;

/**
 * @Author: Xuyifeng
 * @Description: 链路装配
 * @Date: 2025/10/18 15:01
 */

public class LinkArmory<T, D, R> {

    private final BusinessLinkedList<T, D, R> logicLink;

    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);
        }
    }

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}

