package com.practice.wukong.array;


/**
 *
 * Remove	Element
 * Given	an	array	and	a	value,	remove	all	instances	of	that	>	value	in	place	and return	the	new	length.
 * The	order	of	elements	can	be	changed.
 * It	doesn't	matter	what	you	leave beyond	the	new	length.
 * Created by WuKong on 2018/2/22.
 */
public class RemoveArray {

    public static final int[] arrays = new int[]{3,1,2,3,4,3,5,6,3,7,8,9,3,10};

    public static void main(String[] args) {
        int value = 3,index=0;
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]==value){
                continue;
            }
            //util no equal value
            arrays[index] = arrays[i];
            index++;
        }

        for(int j=0;j<index;j++){
            System.out.print(arrays[j]+" , ");
        }

    }
}
