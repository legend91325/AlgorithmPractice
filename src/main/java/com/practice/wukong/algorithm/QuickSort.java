package com.practice.wukong.algorithm;

import java.util.Arrays;

/**
 * Created by WuKong on 2018/8/5.
 */
public class QuickSort {
    /**
     * 快速排序为什么要以基准值得另一侧开始比较？
     * 逻辑思维，关注点在相遇的时候，从左侧先走相遇的时候可以保证左边的都是小于标准值的，但是相遇时候的值是要大于标准值（或者已经走到最右边都没有大于标准值的），从右侧走正好是右边都是大于标准值的，但是相遇的时候值是小于标准值（或者走到 最左边都没有小于标准值）。所以要从基数的对面开始。两种情况，就看你从哪开始扫描。不一定非要从右边开始哦！也可以从左边的，那标准值就选右边的。
     * http://developer.51cto.com/art/201403/430986.htm
     * https://blog.csdn.net/w282529350/article/details/50982650
     *
     */

    public static void quicksort(int[] arrays,int start,int end){
        if(start<end){
            int p = partition(arrays,start,end);
            quicksort(arrays,start,p-1);
            quicksort(arrays,p+1,end);
        }

    }

    static int partition(int[] arrays,int start,int end){
        int p = arrays[start];
        while (start<end){

            while (arrays[end]>=p&&end>start){
                end--;
            }
            arrays[start] = arrays[end];

            while (arrays[start]<=p&&end>start){
                start++;
            }
            arrays[end] = arrays[start];

        }
        arrays[end] = p;
        return end;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,23,43,55,3,6,9,10,11,23,16,14,2,3,4,5,6,98};
        quicksort(arrays,0,arrays.length-1);
        System.out.println(Arrays.toString(arrays));

    }
}
