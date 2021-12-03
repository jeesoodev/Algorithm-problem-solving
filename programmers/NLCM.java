// https://programmers.co.kr/learn/courses/30/lessons/12953
// N개의 최소공배수

import java.io.*;
import java.util.*;

class Solution {
    
    int arrSize;
    int ans = 1;
    
    public int solution(int[] arr) {
        arrSize = arr.length;  
        int multiNum = 2; // 나누는 첫 숫자
        int cnt; //몇 개의 숫자가 나뉘어 떨어지는가. 2개 이상일 때 나누기 적용 가능
        
        Set<Integer> set = new HashSet<>(); // multiNum으로 나눠 떨어지는 원소의 index들 저장
        
        while(true){
            boolean flag = false; // multiNum이 모든 숫자보다 커지면 break
            cnt = 0; // 초기화
            
            for(int i=0; i<arrSize; i++){
                if(arr[i]%multiNum==0){
                    set.add(i);
                    cnt++;
                }
                if(!flag && arr[i]>=multiNum){
                    flag = true; //나누는 숫자보다 값이 작으므로 나누기 가능
                }
            }//배열 원소 다 돌면서 multiNum으로 나누어 떨어지는 숫자 기록
            
            if(cnt >= 2)  solve(arr, set, multiNum);
            else multiNum++; // 나누는 숫자 하나 증가시켜주기
                    
            set.clear(); // set 비워주기
            
            if(!flag) break; // 나누는 숫자가 더 커져버리는 경우 break. 모든 multiNum을 고려한 것
        }//최소공배수 구하기

        for(int i=0; i<arrSize; i++){
            ans *= arr[i];
        } // 나뉘어지지 않은 모든 숫자 계산

        return ans;
    }//Sol
    
    void solve(int[] arr, Set<Integer> set, int multiNum){
        Iterator<Integer> iterSet = set.iterator();
        ans *= multiNum; // 공통 배수 곱해주기
        while(iterSet.hasNext()){
            int index = iterSet.next();
            arr[index] = arr[index]/multiNum;
        }
    }
    
}//Class