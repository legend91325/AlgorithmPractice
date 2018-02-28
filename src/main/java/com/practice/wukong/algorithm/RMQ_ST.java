package com.practice.wukong.algorithm;

import java.util.Arrays;

/**
 *
 * http://smwlover.github.io/blog/2016/05/23/rmq-st/
 * Created by WuKong on 2018/2/27.
 */
public class RMQ_ST {

    /**
     * 小于区间长度的最大的幂
     * @param n
     * @return
     */
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

    private static void rMQ_ST(int[] arrays,int[][] minTable,int[][] maxTable){
        int size = arrays.length;
        int count = getLog(size);
        for(int i=0;i<size;i++){
            minTable[i][0] = arrays[i];
            minTable[i][0] = arrays[i];
        }

        int maxCount = getLog(Integer.MAX_VALUE);
        for(int j=1;j< 31;j++){
            for(int i=0;i<= size;i++){
                if(i+getPower(j)-1<= size){
                    try {
                        minTable[i][j] = Math.min(minTable[i][j-1], minTable[i+getPower(j-1)][j-1]);
                        maxTable[i][j] = Math.max(minTable[i][j-1], minTable[i+getPower(j-1)][j-1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("i="+i+"|j="+j);
                    }
                }

            }
        }
    }

    public static int queryMin(int left,int right,int[][] minTable){
        int len = right - left + 1;
        int log = getLog(len);

        int min = Math.min(minTable[left][log], minTable[right-getPower(log)+1][log]);
        return min;
    }

    public static int queryMax(int left,int right,int[][] maxTable){
        int len = right - left + 1;
        int log = getLog(len);

        int min = Math.min(maxTable[left][log], maxTable[right-getPower(log)+1][log]);
        return min;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,9,22,5,6,9,3,1,4,7,11,13,16,65,20,10,9,8};
        int[][] minTable = new int[arrays.length][getLog(arrays.length)+1];
        int[][] maxTable = new int[arrays.length][getLog(arrays.length)+1];
        rMQ_ST(arrays,minTable,maxTable);
        int minValue = queryMin(3,4,minTable);
        System.out.println("minValue="+minValue);
    }
}
