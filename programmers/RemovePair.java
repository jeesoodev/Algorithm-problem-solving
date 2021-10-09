// https://programmers.co.kr/learn/courses/30/lessons/12973
// 짝지어 제거하기

import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s) {
        int sSize = s.length();
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<sSize; i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            } else{
                if(stack.peek()==c){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        
        int answer=-1;
        if(stack.isEmpty()) answer = 1;
        else answer = 0;
        
        return answer;
    }
}