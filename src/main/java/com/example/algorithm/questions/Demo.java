package com.example.algorithm.questions;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
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


    public static void main(String[] args) {
        int[] r = question1(new int[]{1, 3, 6, 29, 39, 17}, 40);
        System.out.println("result:"+ JSONObject.toJSONString(r));
    }
}
