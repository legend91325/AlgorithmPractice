package com.practice.wukong.algorithm;

import java.util.Arrays;

/**
 *
 * http://smwlover.github.io/blog/2016/05/23/rmq-st/
 * Created by WuKong on 2018/2/27.
 */
public class RMQ_ST {

    private static int getLog(int n){
        int count = 0;
        n = n >> 1;
        while (n>0){
            n = n>>1;
            count++;
        }
        return count;
    }

    private static int getPower(int n){
        return 1<< n;
    }

    private static int[][] minTable(int[] arrays){
        int size = arrays.length;
        int count = getLog(size);
        int[][] table = new int[size][count];
        for(int i=0;i<size;i++){
            table[i][0] = arrays[i];
        }
        int power1 = 1;
        int power2 = 2;
        for(int i=1;i<count;i++,power1 <<= 1,power2<<= 1){
            for(int j=0;j<size+1-power2;j++){
                table[i][j] = Math.min(table[i-1][j], table[i-1][j+power1]);
            }
        }
        return table;
    }

    public static int queryMin(int left,int right,int[][] table){
        int len = right - left + 1;
        int log = getLog(len);
        int t = getPower(log);

        int min = Math.min(table[log][left-1], table[log][right-t]);
        return min;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,9,22,5,6,9,3,1,4,7,11,13,16,65,20,10,9,8};
        int[][] table = minTable(arrays);
        for(int i=0;i<table.length;i++){
            System.out.println(Arrays.toString(table[i]));
        }

        int minValue = queryMin(3,4,table);
        System.out.println("minValue="+minValue);
    }
}
