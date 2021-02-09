package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_20_ValidParentheses {
    public boolean isValid(String s) {

        if( s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if ( c == '('){
                stack.push(')');
            }else if ( c == '['){
                stack.push(']');
            }else if ( c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }

        return false;
    }

    @Test
    public void test(){
        boolean i = isValid("()");
        System.out.println(i);
    }
}
