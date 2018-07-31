package com.practice.wukong.algorithm;

/**
 * @Author: WuKong
 * @Date: 2018/7/31
 * @Version 1.0.0
 */
public class InterpolationSearch {

    static int algorithm(int arrays[],int value,int low,int high){
        while (low<high){
            int mid = low+(high-low)*((value-arrays[low])/(arrays[high]-arrays[low]));
            if(arrays[mid]==value){
                return mid;
            }else if(arrays[mid]>value){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int index = algorithm(arrays,20,0,arrays.length-1);
        System.out.println(index);
    }
}
