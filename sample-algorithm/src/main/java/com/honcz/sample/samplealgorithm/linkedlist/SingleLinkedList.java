package com.honcz.sample.samplealgorithm.linkedlist;

/**
 * @author honc.z
 * @date 2019/4/22
 *
 * 单向链表
 */
public class SingleLinkedList {

    /**
     * 链表大小
     */
    private int size;

    /**
     * 头部节点
     */
    private Node headNode;

    /**
     * 链表节点 内部类
     */
    private class Node{
        /**
         * 该节点存储的数据
         */
        private Object data;

        /**
         * 指向的下一个节点
         */
        private Node nextNode;

        public Node(Object data){
            this.data = data;
        }
    }

    /**
     * 在头部添加一个结点
     * 单向链表只能在头部添加结点
     * @param data
     * @return
     */
    public Object add(Object data){
        Node newNode = new Node(data);
        if (size == 0){
            this.headNode = newNode;
        }else {
            newNode.nextNode = this.headNode;
            this.headNode = newNode;
        }
        size++;
        return data;
    }
}
