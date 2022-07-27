package com.example.algorithm.sort;

/**
 * 排序
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = randomArr(10,10);
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static void bubbleUpSort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    swap(arr,j-1,j);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            swap(arr,i,index);
        }
    }

    public static void insertSort(int[] arr) {

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 获取随机数组
     *
     * @param maxValue
     * @param maxSize
     * @return
     */
    public static int[] randomArr(int maxValue, int maxSize) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 有序数组变随机数组
     *
     * @param arr
     */
    public static void transRandomArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }
}
