package com.algorithm.tree;

public class BinaryTree<Key extends Comparable<Key>, Value>{

    // 1. 成员变量
    // 1.1 记录根节点
    private Node root;
    // 1.2 记录树中元素的个数
    private int N;

    private class Node <Key,Value> {

        // 1. 成员变量
        // 存储键
        public Key key;

        // 存储值
        private Value value;

        // 记录子节点
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // 2. 成员方法
    // 2.1 size 获取树中元素的个数
    public int size(){
        return N;
    }
    // 2.2 push() 向树中插入一个键值对
    public void put(Key key, Value value){

    }

}
