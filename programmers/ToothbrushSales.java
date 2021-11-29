// https://programmers.co.kr/learn/courses/30/lessons/77486#
// 다단계 칫솔 판매

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int mSize = enroll.length;
        int[] ans = new int[mSize];
        
        Map<String, String> parentsMap = new HashMap<>(); // 부모 기억 map
        Map<String, Integer> ansMap = new HashMap<>(); // 수익 map
        
        // 각 부모 저장 & 사람마다 수익 0으로 초기화
        for(int i=0; i<mSize; i++){
            String child = enroll[i];
            String parent = referral[i];
            parentsMap.put(child, parent);
            ansMap.put(child, 0);
        }
        ansMap.put("-", 0);
        
        for(int i=0, sSize=seller.length; i<sSize; i++){
            String key = seller[i];
            int money = amount[i]*100; // 판매 이익

            while(true){
                int remain = (int)(money*0.1);
                ansMap.put(key, ansMap.get(key)+(money-remain));
                money = remain;
                key = parentsMap.get(key);
                if(money/10<1) {
                    ansMap.put(key, (ansMap.get(key))+money);
                    break;
                }
                if(!parentsMap.containsKey(key)) break;
            }
        }// 이득 계산
        
        // 정답 배열에 저장
        for(int i=0; i<mSize; i++){
            String key = enroll[i];
            ans[i] = ansMap.get(key);
        }
        return ans;
    }
}