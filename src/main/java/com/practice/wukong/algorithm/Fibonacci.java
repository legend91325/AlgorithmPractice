package com.practice.wukong.algorithm;

/**
 *
 * 矩阵求解斐波那契
 * @Author: WuKong
 * @Date: 2018/7/16
 * @Version 1.0.0
 */
public class Fibonacci {

    /**
     * 矩阵乘积 i行 j列
     * @param a
     * @param b
     */
    public static int [][] multi(int [][] a, int [][] b){
        int [][] c = new int[][]{{0,0},{0,0}};
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for (int k=0;k<2;k++){
                    c[i][j] = c[i][j]+a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 矩阵求解斐波那契
     * @param n
     */
    public static int  matrix_Fibonacci(int n){
        // 元矩阵，这里可以把元矩阵看做是2**0=1
        int[][] base = new int[][]{{1,1},{1,0}};
        // 结果矩阵  最开始的结果矩阵也可以看做是1，因为这个矩阵和任意二阶A矩阵相乘结果都是A
        int[][] res = new int[][]{{1,0},{0,1}};
        while (n>0){
            if((n&1)==1){
                res = multi(res,base);
            }
            base = multi(base,base);
            n>>=1;
        }
        return res[0][1];
    }

    public static void main(String[] args) {
        System.out.println(matrix_Fibonacci(1));
    }

}
