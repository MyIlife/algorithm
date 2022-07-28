package com.example.algorithm.questions;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Rock
 * @date 2022/7/27 10:10 上午
 * @description LeetCode
 */
public class Demo {

    /**
     * 1、题：
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     * 举例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] question1(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<arr.length ; i++) {
            int v0 = arr[i];
            int v1 = target - v0;
            if(map.containsKey(v1)){
                return new int[]{map.get(v1),i};
            }
                map.put(v0,i);

        }
        throw new RuntimeException("no find");
    }

    /**
     * 2、题：
     * 给定两个链表分别代表两个非负整数，链表的每个结点分别分别存储整数的每位数字，且是逆序存储。求解这两个整数的和并以链表的形式返回计算的结果。
     *
     * 例如：
     *   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *   输出：7 -> 0 -> 8
     */
    public static Node<Integer> question2(Node<Integer> n1,Node<Integer> n2){
        Node<Integer> result = new Node<>();
        question2Recursion(n1,n2,0,result);
        return result;
    }

    private static void question2Recursion(Node<Integer> n1, Node<Integer> n2,int carry, Node<Integer> result) {
        if (n1 == null && n2 == null && carry == 0) {
            return;
        }
        if(n1 == null && n2 == null && carry > 0){
            Node<Integer> next = new Node<>();
            next.setData(carry);
            result.setNext(next);
            return;
        }

        int v1 = 0;
        int v2 = 0;
        if (n1 != null) {
            v1 = n1.getData();
        }
        if (n2 != null) {
            v2 = n2.getData();
        }
        int sum = v1 + v2 + carry;
        int newCarry = 0;
        int value = sum;
        if (sum > 10) {
            value = sum / 10;
            newCarry = 1;
        }
        Node<Integer> next = new Node<>();
        result.setData(value);
        result.setNext(next);
        question2Recursion(n1 == null ? null : n1.next, n2 == null ? null : n2.next, newCarry, next);
    }


    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(
                2,new Node<>(5,new Node<>(9,new Node<>(4,new Node<>(3,null))))
        );


        Node<Integer> n2 = new Node<>(6,new Node<>(1,null));
        Node<Integer> result = question2(n1, n2);
        Node<Integer> p = result;
        while (p != null){
            System.out.println(p.getData());
            p = p.next;

        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Node<T> {
        private T data;
        private Node<T> next;
    }
}
