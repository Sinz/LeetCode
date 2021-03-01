package com.algorithm.tree;

/*
 * @Author Zhao.J
 * @Date 17:08 2021/3/1
 * @Description
 */
public class Node <Integer,String>{

    // 1. 成员变量
    // 存储键
    public int key;

    // 存储值
    private String value;

    // 记录子节点
    public Node left;
    public Node right;

    public Node(int key, String value, Node left, Node right){
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
