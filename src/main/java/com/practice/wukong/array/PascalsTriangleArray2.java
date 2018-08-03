package com.practice.wukong.array;

/**
 *  Given	numRows,	generate	the	first	numRows	of	Pascal's	triangle.
 * For	example,	given	numRows	=	5,	Return
 *  [1,4,6,4,1]
 * Created by WuKong on 2018/2/22.
 */
public class PascalsTriangleArray2 {
    private static int[][] arrays;

    public static void main(String[] args) {
        int totalLevel = 10;
        arrays = new int[2][totalLevel];
        for(int level=0;level<totalLevel;level++){
            builderTriangle(level,arrays);
        }
        System.out.print("[ ");
        for(int i=0;i<totalLevel;i++){
            System.out.print(arrays[totalLevel%2][i]+" ");
        }
        System.out.print("]\n");

    }

    private static void builderTriangle(int level,int[][] arrays){
        if(level==0){
            arrays[level][level]=1;
        }else {
            //C(n,0)=1
            //C(n,n)=1
            arrays[level%2][0]=1;
            arrays[level%2][level]=1;
            for(int i=1;i<level;i++){
                arrays[(level+1)%2][i] = arrays[(level-1)%2][i-1]+arrays[(level-1)%2][i];
            }
        }


    }
}
