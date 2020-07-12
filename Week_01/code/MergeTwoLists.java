package org.millet.algorithm.week_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并两个有序链表
 * Created by yutao
 * Create date 2020/7/12 8:55
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));
        ListNode l2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));
        ListNode resultList = mergeTwoLists2(l1, l2);
        ListNode tempList = resultList;
        while (tempList.next != null){
            System.out.print(tempList.val + ", ");
            tempList = tempList.next;
        }
    }

    /**
     * 递归
     * 1、先写递归的终止条件
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    /**
     * 遍历两个链表，将数据存到数组中 --> 数组排序 --> 转换为链表
     * 1、两个链表至少一个不为空
     * 2、new一个新链表，遍历两个链表一次插入数据
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        List<Integer> list = new ArrayList<>();
        ListNode l1Temp = l1;
        while (l1Temp != null ){
            list.add(l1Temp.val);
            l1Temp = l1Temp.next;
        }

        ListNode l2Temp = l2;
        while (l2Temp != null){
            list.add(l2Temp.val);
            l2Temp = l2Temp.next;
        }

        list.sort(Comparator.naturalOrder());

        ListNode newNode = new ListNode();
        ListNode temp = newNode;
        for(int i = 0; i < list.size(); i++){
            temp.val = list.get(i);
            if(i + 1 < list.size()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return newNode;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
