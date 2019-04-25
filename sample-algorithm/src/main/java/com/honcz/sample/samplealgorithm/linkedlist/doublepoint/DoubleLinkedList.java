package com.honcz.sample.samplealgorithm.linkedlist.doublepoint;

import com.honcz.sample.samplealgorithm.linkedlist.singlepoint.SingleLinkedList;

/**
 * @author honc.z
 * @date 2019/4/23
 *
 * 双向链表
 */
public class DoubleLinkedList {
    private Node headNode;

    private Node tailNode;

    private int size;

    private class Node{
        /**
         * 该节点存储的数据
         */
        private Object data;

        /**
         * 指向的下一个节点
         */
        private Node nextNode;

        /**
         * 指向的前一个结点
         */
        private Node priviousNode;

        public Node(Object data){
            this.data = data;
        }
    }

    public void addHead(Object data){
        Node newNode = new Node(data);
        if (size == 0){
            headNode = newNode;
            tailNode = newNode;
            size++;
        }else {
            headNode.priviousNode = newNode;
            newNode.nextNode = headNode;
            headNode = newNode;
            size++;
        }
    }

    /**
     * 控制台打印链表
     * @return
     */
    public String display(){
        Node pointer = this.headNode;
        int nodeSize = this.size;
        if (size > 0){
            if (size == 1){
                System.out.println("链表的情况是"+pointer.data);
            }else {
                StringBuffer sb = new StringBuffer(0);
                while (nodeSize > 0){
                    sb.append(pointer.data.toString());
                    pointer = pointer.nextNode;
                    nodeSize--;
                }
                System.out.println("链表的情况是"+sb.toString());
            }
        }else {
            System.out.println("链表为空");
        }
        return null;
    }
}
