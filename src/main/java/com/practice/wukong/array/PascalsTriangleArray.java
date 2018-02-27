package com.practice.wukong.array;

/**
 *  Given	numRows,	generate	the	first	numRows	of	Pascal's	triangle.
 * For	example,	given	numRows	=	5,	Return
 * [   [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1] ]
 * Created by WuKong on 2018/2/22.
 */
public class PascalsTriangleArray {
    private static int[][] arrays;

    public static void main(String[] args) {
        int totalLevel = 10;
        arrays = new int[totalLevel][totalLevel];
        for(int level=0;level<totalLevel;level++){
            builderTriangle(level,arrays);
        }
        for(int h=0;h<totalLevel;h++){
            System.out.print("[ ");
            for(int l=0;l<=h;l++){
                System.out.print(arrays[h][l]+" ");
            }
            System.out.print("]\n");
        }
    }

    private static void builderTriangle(int level,int[][] arrays){
        if(level==0){
            arrays[level][level]=1;
        }else {
            //C(n,0)=1
            //C(n,n)=1
            arrays[level][level]=1;
            arrays[level][0]=1;
            for(int i=1;i<level;i++){
                arrays[level][i] = arrays[level-1][i-1]+arrays[level-1][i];
            }
        }


    }
}
