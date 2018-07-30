package com.practice.wukong.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WuKong
 * @Date: 2018/7/30
 * @Version 1.0.0
 */
public class JohnsonTrotter {
    enum Direct {
        LEFT,
        RIGHT
    }
    static class Node{
        public int value;
        public Direct direct;

        public Node(int value, Direct direct) {
            this.value = value;
            this.direct = direct;
        }
    }

    private static Node getMaxMoveNode(Node[] nodes){
        Node maxNode = null;
        for(int i=0;i<nodes.length;i++){
            if(Direct.LEFT.equals(nodes[i].direct)
                    &&i!=0&&nodes[i].value>nodes[i-1].value){
                if(maxNode ==null||nodes[i].value> maxNode.value){
                    maxNode = nodes[i];
                }
            }else if(Direct.RIGHT.equals(nodes[i].direct)
                    &&i<nodes.length-1&&nodes[i].value>nodes[i+1].value){
                if(maxNode==null||nodes[i].value>maxNode.value){
                    maxNode = nodes[i];
                }
            }
        }
        return maxNode;
    }
    public static List<String> algorithm(Node[] nodes){
        Node moveNode = null;
        List<String> allArranges = new ArrayList<String>();
        allArranges.add(toShownString(nodes));
        //循环条件 存在可移动的节点（取最大的）
        while ((moveNode = getMaxMoveNode(nodes))!=null){
            nodes = switchPositonAndDirect(nodes,moveNode);
            allArranges.add(toShownString(nodes));
        }
        return allArranges;
    }


    private static Node[] switchPositonAndDirect(Node[] nodes,Node moveNode){
        Boolean alreadySwitched = Boolean.FALSE;
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].value>moveNode.value){
                //方向更改
                if(Direct.LEFT.equals(nodes[i].direct)){
                    nodes[i].direct = Direct.RIGHT;
                }else {
                    nodes[i].direct = Direct.LEFT;
                }
            }else if(nodes[i].value==moveNode.value&&!alreadySwitched){
                alreadySwitched = Boolean.TRUE;
                if(Direct.LEFT.equals(moveNode.direct)){
                    //互换
                    nodes[i] = nodes[i-1];
                    nodes[i-1] = moveNode;
                }else {
                    nodes[i] = nodes[i+1];
                    nodes[i+1] = moveNode;
                }
            }
        }
        return nodes;
    }


    private static String toShownString(Node[] nodes){
        StringBuffer str = new StringBuffer();
        for(Node node:nodes){
            str = str.append(node.value);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[]{new Node(1,Direct.LEFT),new Node(2,Direct.LEFT),new Node(3,Direct.LEFT)};
        List<String> algorithmList = algorithm(nodes);
        for(String res: algorithmList){
            System.out.println(res);
        }

    }
}
