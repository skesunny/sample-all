package com.honcz.sample.samplealgorithm.linkedlist.singlepoint;

import com.honcz.sample.samplealgorithm.linkedlist.singlepoint.SingleLinkedList;

/**
 * @author honc.z
 * @date 2019/4/23
 *
 * 专门用于测试链表的影分身
 */
public class HonczSingleLinkedShadow {
    public static void main(String[] args){
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add("A");
        linkedList.display();
        linkedList.add("B");
        linkedList.display();
        linkedList.add("C");
        linkedList.display();
        linkedList.delete();
        linkedList.display();
        linkedList.deleteNode("A");
        linkedList.display();
        linkedList.find("B");
        linkedList.delete();
        linkedList.display();
        linkedList.delete();
    }
}
