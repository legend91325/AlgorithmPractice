package com.practice.wukong.algorithm;

import java.util.Arrays;

/**
 * Created by WuKong on 2018/8/5.
 */
public class QuickSort {

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
