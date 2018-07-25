package com.practice.wukong.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否为环形
 * @Author: WuKong
 * @Date: 2018/7/25
 * @Version 1.0.0
 */
public class RingToplogy {

    /**
     * 每个点上只有两条边
     * 所有点是连通性，全连通
     * 时间复杂度 O(n*n)
     * 空间复杂度 O(n)
     * @param matrix
     * @return
     */
    public static Boolean judge(int[][] matrix){
        int n = matrix.length;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int i=0;
        int swap = i;
        while (true){
            int count=0;
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    if(!visited.contains(j)){
                        //未访问过，下一个节点
                        swap = j;
                    }
                    visited.add(j);
                    count++;
                }
                if(count>2){
                    //不符合一个节点只有两条边
                    return Boolean.FALSE;
                }
            }
            if(count!=2){
                //不符合一个节点只有两条边
                return Boolean.FALSE;
            }

            if(i==swap){
                if(visited.size()<n){
                    //不是全连通
                    return Boolean.FALSE;
                }else {
                    return Boolean.TRUE;
                }
            }else {
                i = swap;
            }

        }



    }

    public static void main(String[] args) {
        //A0 B1 C2 D3 E4 F5
        //false  两个三角 非全连通 ACF BDE
        int[][] matrix_false = new int[][]{{0,0,1,0,0,1},{0,0,0,1,1,0},{1,0,0,0,0,1},{0,1,0,0,1,0},{0,1,0,1,0,0},{1,0,1,0,0,0}};
        int[][] matrix_true = new int[][]{{0,1,0,0,0,1},{1,0,1,0,0,0},{0,1,0,1,0,0},{0,0,1,0,1,0},{0,0,0,1,0,1},{1,0,0,0,1,0}};
        System.out.println(judge(matrix_false));
        System.out.println(judge(matrix_true));
    }


}
