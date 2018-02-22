package com.practice.wukong.array;

/**
 *
 * Given	a	sorted	array,	remove	the	duplicates	in	place	such	that	>	each	element appear	only	once	and	return	the	new	length.
 * Do	not	allocate	extra	space	for	another	array,	you	must	do	this	in	place	with constant	memory.
 * For	example,	Given	input	array	A	=	[1,1,2],
 * Your	function	should	return	length	=	2,	and	A	is	now	[1,2].
 * Created by WuKong on 2018/2/22.
 */
public class RemoveDuplicatesSortedArray {

    public static final int[] arrays = new int[]{1,2,2,2,3,4,5,6,6,6,7,7,8,9,10};
    public static void main(String[] args) {
        int index = 1;
        for(int i=index+1;i<arrays.length;i++){
            if(arrays[i]==arrays[index]){
                continue;
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
