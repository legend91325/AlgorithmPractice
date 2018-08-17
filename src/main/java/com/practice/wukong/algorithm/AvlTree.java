package com.practice.wukong.algorithm;

/**
 * https://blog.csdn.net/collonn/article/details/20128205
 * https://blog.csdn.net/qq_25806863/article/details/74755131
 * Created by WuKong on 2018/8/17.
 */
public class AvlTree <T extends Comparable<T>>{


    static class AvlNode<T> {
        AvlNode<T> leftNode;
        AvlNode<T> rightNode;
        T data;
        //树高
        int height;


        public AvlNode(T data) {
            this(null,null,data);
        }

        public AvlNode(AvlNode<T> leftNode, AvlNode<T> rightNode, T data) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;
        }
    }


    public int height(AvlNode node){
        return node==null?-1:node.height;
    }

    /**
     *  左子树的左边插入
     *  右旋
     * @param node
     * @return
     */
    public AvlNode<T> rightRotate(AvlNode<T> node){
        AvlNode<T> newTree = node.leftNode;
        node.leftNode = newTree.rightNode;
        newTree.rightNode = node;
        node.height = Math.max(height(node.leftNode),height(node.rightNode))+1;
        newTree.height = Math.max(height(newTree.leftNode),height(newTree.rightNode))+1;
        return newTree;
    }

    /**
     * 左子树的右边插入
     * 先左旋后右旋
     * @param node
     * @return
     */
    public AvlNode<T> leftThenRightRotate(AvlNode<T> node){
        node.leftNode = leftRotate(node.leftNode);
        return rightRotate(node);
    }

    /**
     * 右子树的右边插入
     *  左旋
     * @param node
     * @return
     */
    public AvlNode<T> leftRotate(AvlNode<T> node){
        AvlNode<T> newTree = node.rightNode;
        node.rightNode = newTree.leftNode;
        newTree.leftNode = node;
        node.height = Math.max(height(node.leftNode),height(node.rightNode))+1;
        newTree.height = Math.max(height(newTree.leftNode),height(newTree.rightNode))+1;
        return newTree;
    }

    /**
     * 右子树的左边插入
     *  先右旋再左旋
     * @param node
     * @return
     */
    public AvlNode<T> rightThenLeftRotate(AvlNode<T> node){
        node.rightNode = rightRotate(node.rightNode);
        return leftRotate(node);
    }


    public AvlNode<T> insert(AvlNode<T> node, T value){
        if(node ==null){
            return new AvlNode<T>(value);
        }
        int compareValue = node.data.compareTo(value);
        if(compareValue>0){
            //递归定位到插入位置,
            node.leftNode = insert(node.leftNode,value);
            //插入左子树，打破平衡 要进行旋转  右旋 或者先左旋后右旋
            if(height(node.leftNode)-height(node.rightNode)==2){
                if(value.compareTo(node.leftNode.data)<0){
                    //LL 右旋
                    node = rightRotate(node);
                }else {
                    //LR 先右旋后左旋
                    node = leftThenRightRotate(node);
                }
            }
        }else if(compareValue<0){
            node.rightNode = insert(node.rightNode,value);
            if(height(node.rightNode)-height(node.leftNode)==2){
                //插入右子树，打破平衡 要进行旋转  左旋 或者先右旋后左旋
                if(value.compareTo(node.rightNode.data)>0){
                    node = leftRotate(node);
                }else {
                    node = rightThenLeftRotate(node);
                }
            }
        }else {
            //等于
        }
        node.height = Math.max(height(node.leftNode),height(node.rightNode))+1;
        return node;
    }


    public void printTree(AvlNode<T> node){
        if(node!=null){
            System.out.print(node.data);
            printTree(node.leftNode);
            printTree(node.rightNode);
        }

    }

    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        AvlNode<Integer> root = null;
        for(int i=0;i<10;i++){
            root = avlTree.insert(root,i);
        }
        System.out.println("tree height : "+root.height);
        avlTree.printTree(root);
    }
}
