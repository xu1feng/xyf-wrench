package edu.xyf.wrench.design.framework.link.model2.chain;

/**
 * @Author: Xuyifeng
 * @Description: 链接口
 * @Date: 2025/10/18 14:55
 */

public interface ILink<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

}
