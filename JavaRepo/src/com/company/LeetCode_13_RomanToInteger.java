package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_13_RomanToInteger {
    public int romanToInt(String s) {

        Map<Character, Integer> numberal2Int = new HashMap<>();
        numberal2Int.put('M',1000);
        numberal2Int.put('D',500);
        numberal2Int.put('C',100);
        numberal2Int.put('L',50);
        numberal2Int.put('X',10);
        numberal2Int.put('V',5);
        numberal2Int.put('I',1);

        int result = 0;
        for (int i = 0; i < s.length()-1 ; i++) {
            result += numberal2Int.get(s.charAt(i));
            if (numberal2Int.get(s.charAt(i)) < numberal2Int.get(s.charAt(i+1))){
                result -= numberal2Int.get(s.charAt(i))*2;
            }
        }

        return result+numberal2Int.get(s.charAt(s.length()-1));
    }
}
