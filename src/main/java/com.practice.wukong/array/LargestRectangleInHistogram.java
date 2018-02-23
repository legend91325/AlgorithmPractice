package com.practice.wukong.array;

import java.util.*;

/**
 * Created by WuKong on 2018/2/22.
 */
public class LargestRectangleInHistogram {

    private static List<Integer> arrays = new ArrayList<Integer>(){{
        add(2);
        add(1);
        add(5);
        add(6);
        add(2);
        add(3);
        add(3);
        add(3);
        add(3);
    }};
    public static void main(String[] args) {
        Stack<Integer> stackIndex = new Stack<Integer>();
        //考虑最后一个元素
        arrays.add(0);
        Integer max = 0;
        for(int index=0;index<arrays.size();){
            if(stackIndex.isEmpty()||arrays.get(index)>arrays.get(stackIndex.peek())){
                stackIndex.push(index);
                index++;
            }else {
                Integer heightIndex = stackIndex.pop();
                Integer rightIndex = index;
                Integer width = stackIndex.isEmpty()?rightIndex:rightIndex-stackIndex.peek()-1;
                Integer height = arrays.get(heightIndex);
                max = Math.max(max,height*width);
                System.out.printf("max change max="+max);
            }
        }
        System.out.printf("Max ="+max);
    }

}
