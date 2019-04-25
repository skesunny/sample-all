package com.honcz.sample.samplealgorithm.linkedlist.singlepoint;

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
        System.out.println("开始新增结点"+data);
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

    /**
     * 删除头部结点
     */
    public void delete(){
        if (size > 0) {
            System.out.println("开始删除头部结点" + this.headNode.data);
            this.headNode = headNode.nextNode;
            size--;
        }else {
            System.out.println("链表为空无法删除");
        }
    }

    /**
     * 查找指定结点
     * @param data
     * @return
     */
    public Boolean find(Object data){
        System.out.println("开始查找指定结点"+data);
        Node pointer = headNode;
        int size = this.size;
        while(size > 0){
            if (data == pointer.data){
                System.out.println("成功找到指定结点"+data);
                return true;
            }
            pointer = pointer.nextNode;
            size--;
        }
        System.out.println("查找指定结点"+data+"失败");
        return false;
    }

    /**
     * 删除指定结点，成功返回ture
     * @param data
     * @return
     */
    public Boolean deleteNode(Object data){
        System.out.println("开始删除指定结点"+data);
        Node pointer = this.headNode;
        Node previous = this.headNode;
        while (pointer.data != data){
            if (pointer.nextNode == null){
                System.out.println("没有找到指定结点"+data+",无法删除");
                return false;
            }
            previous = pointer;
            pointer = previous.nextNode;
        }
        //删除的是头结点
        if (pointer == this.headNode){
            this.headNode = this.headNode.nextNode;
            size--;
        }else {
            previous.nextNode = pointer.nextNode;
            size--;
        }
        System.out.println("删除指定结点"+data+"成功");
        return true;
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
