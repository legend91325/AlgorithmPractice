package com.practice.wukong.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WuKong on 2018/4/14.
 */
public class SubStringProblem {
    public static void main(String[] args) {

        List<String> handler = new ArrayList<>();
        for (int i=0;i<1000;i++){
            HugeStr h = new HugeStr();
            ImprovedHugeStr ih = new ImprovedHugeStr();
            handler.add(h.getSubString(1,5));
        }
    }

    static class HugeStr {
        private String str = new String(new char[1000000]);
        public String getSubString(int begin,int end){
            return str.substring(begin,end);
        }
    }

    static class ImprovedHugeStr {
        private String str = new String(new char[1000000]);
        public String getSubString(int begin,int end){
            //substring 没有强引用，会被回收，只有截取这部分会引用
            return new String(str.substring(begin,end));
        }
    }
}
