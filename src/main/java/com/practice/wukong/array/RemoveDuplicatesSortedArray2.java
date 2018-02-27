package com.practice.wukong.array;

/**
 * Follow	up	for	"Remove	Duplicates":	What	if	duplicates	are	allowed	at	most twice?
 * For	example,	Given	sorted	array	A	=	[1,1,1,2,2,3],
 * Your	function	should	return	length	=	5,	and	A	is	now	[1,1,2,2,3].
 * Created by WuKong on 2018/2/22.
 */
public class RemoveDuplicatesSortedArray2 {

    public static final int[] arrays = new int[]{1,2,2,2,3,4,5,6,6,6,7,7,7,7,8,9,10};
    public static void main(String[] args) {
        int index = 1;
        int count = 0;
        for(int i=index+1;i<arrays.length;i++){
            if(arrays[i]==arrays[index]){
                count++;
                if(count>1){
                    continue;
                }
            }else {
                count = 0;
            }

            index++;
            arrays[index] = arrays[i];
        }
        System.out.println("size = "+(index+1));
        for(int j=0;j<=index;j++){
            System.out.print( arrays[j]+" , ");
        }
    }
}
