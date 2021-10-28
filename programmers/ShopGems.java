// 보석 쇼핑
// https://programmers.co.kr/learn/courses/30/lessons/67258


import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        int gemSize = gems.length;
        
        // 1. 전체 돌면서 보석 종류 넣어주기
        Set<String> set = new HashSet<>();
        for(String s : gems){
            set.add(s);
        }
        
        // 2. 전체 돌면서 최소 길이의 queue 만들기
        int start = 0;
        int startPoint = 0;
        int end = Integer.MAX_VALUE;
        
        Queue<String> queue = new LinkedList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<gemSize; i++){
            String s = gems[i];
            map.put(s, map.getOrDefault(s, 0)+1);
            queue.add(s);
            
            while(map.get(queue.peek()) > 1){
                String tmp = queue.poll();
                start++;
                map.put(tmp, map.get(tmp)-1);
            }
            
            if(map.size()==set.size() && end > queue.size()) {
                end = queue.size();
                startPoint = start;
            }

        }

        return new int[]{startPoint+1, startPoint+end};
    
    }//Sol
}//Class