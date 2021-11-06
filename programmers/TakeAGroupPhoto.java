//https://programmers.co.kr/learn/courses/30/lessons/1835
//단체 사진 찍기

import java.io.*;
import java.util.*;

class Solution {
    
    int ans = 0;
    char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}; //카카오 프렌즈들 배열에 담기
    boolean[] selected = new boolean[8];
    Map<Character,Integer> map = new HashMap<>(); //카카오프렌즈 이름을 key로, 서있는 위치를 value로 저장
    String[] condition; // 조건 배열인 data를 전역에서 사용하도록
    
    public int solution(int n, String[] data) {
        condition = data;
        dfs(0); //하나도 안뽑은 상태에서 출발
        return ans;
    }
    
    void dfs(int cnt){
        if(cnt==8){ 
            checkData(); //줄이 완성되면 조건에 맞는지 확인하러 보내기
            return;
        }
               
        for(int i=0; i<8; i++){
            if(selected[i]) continue;
            
            // 선택했을 때
            map.put(kakao[i],cnt); //캐릭터와 위치 저장
            selected[i]=true; //선택 표시
            dfs(cnt+1); //다음꺼 뽑으로 고고
            selected[i]=false; //선택 되돌리기
        }
    }
    
    void checkData(){
        for(int i=0, size=condition.length; i<size; i++){ // 모든 조건 확인
            String s = condition[i];
            char c1 = s.charAt(0); //캐릭터1
            char c2 = s.charAt(2); //캐릭터2
            char compare = s.charAt(3); //비교 연산
            int std = Integer.parseInt(s.substring(4)); // 비교할 숫자
            
            int diff = Math.abs(map.get(c1) - map.get(c2))-1; //위치 사이에 몇 명의 캐릭터가 있는지
            if(compare=='<'){
                if(!(diff < std)) return;
            } else if(compare=='>'){
                if(!(diff > std)) return;
            } else {
                if(!(diff == std)) return;
            }
        }//Data 배열 반복
        
        // 조건을 모두 통과했다는 의미이므로 ans++;
        ans++;
    }//checkData
    
}//Class


/* 풀이 방법
1. 순열로 줄을 세워본다.(모든 경우의 수를 고려)
2. 줄이 완성될 때마다(when cnt==8) 모든 조건에 맞는지 확인하여, 맞으면 ans++
*/
