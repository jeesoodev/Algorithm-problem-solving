// https://programmers.co.kr/learn/courses/30/lessons/42839

import java.io.*;
import java.util.*;

class Solution {
    
    static int ans = 0;
    static final int range = 10000000;
    static boolean[] check = new boolean[range];
    static char[] arr;
    static boolean[] selected;
    static int arrSize;
    static StringBuilder sb;
    
    
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        arrSize = arr.length;
        sb = new StringBuilder();
        selected = new boolean[arrSize];
        fillCheck();
        for(int i=1; i<=arrSize; i++){
            makeNum(i, 0, sb);
        }
        
        return ans;
    }
    
    public void makeNum(int std, int cnt, StringBuilder sb){
        if(cnt == std){
            int num = Integer.parseInt(sb.toString());
            if(!check[num]) { 
                System.out.println(num);
                ans++;
                check[num] = true;
            }
            return;
        }
        
        for(int i=0; i<arrSize; i++){
            if(!selected[i]){
                selected[i] = true;
                sb.append(arr[i]);
                makeNum(std, cnt+1, sb);
                sb.setLength(sb.length()-1);
                selected[i] = false;
            }
        }
    }
    
    public void fillCheck(){
        
        // 0과 1은 소수에서 제외
        check[0] = true;
        check[1] = true;
        
        for(int i=2; i<range; i++){
            if(check[i]) continue;
            
            int multi = 2;
            int target = i;
            while(true){
                target = i*multi;
                if(target>=range) break;
                check[target] = true;
                multi++;
                
            }
        }
    }//fillCheck
    
}//Class