// https://programmers.co.kr/learn/courses/30/lessons/60057
// 문자열 압축

import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 1000;
        int size = s.length(); //문자열 길이
        
        if(size==1) return 1; // 5. 문자열이 한 자리 수 일때 처리 안해줘서 틀렸었음
        
        for(int unit=1, reSize = size/2; unit<=reSize; unit++){

            boolean flag = false; // 앞에 숫자를 붙였는지 표시하기 위한 값
            String prev = s.substring(0, unit); // 맨 처음 비교 기준
            String cur;
            int repeat = 1; //반복 카운트
            
            int cnt = unit; // --여기를 1로 잘못 설정
            int stt = unit; // --여기를 1로 잘못 설정
            
            boolean[] checkRepeat = new boolean[3];
            while(true){
                if(stt+unit > size) break; //위치를 while문 맨 아래에 잘못 넣어서 outofbounds 에러 & 등호 잘못 넣음  
                cur = s.substring(stt, stt+unit); //새로운 단위

                if(prev.equals(cur)){
                    repeat++;  // -- 아래 if 문 안에 잘못 넣음
                    if(!flag) { cnt++; flag=true; } // 중복되는 숫자(횟수)를 앞에 넣어주기 때문에 cnt 증가
                    stt += unit;
                    if(repeat>=10 && !checkRepeat[0]){
                        cnt++;
                        checkRepeat[0] = true;
                    } else if(repeat>=100 && !checkRepeat[1]){
                        cnt++;
                        checkRepeat[1] = true;
                    } else if(repeat>=1000 && !checkRepeat[2]){
                        cnt++;
                        checkRepeat[2] = true;
                    }
                    continue;
                }
                repeat = 1;
                prev = cur;
                flag = false;
                cnt += unit; // prev와 cur이 같지 않을 때, 반복 단위를 개수에 더해줌
                stt += unit; // 시작하는 index 증가 
                Arrays.fill(checkRepeat, false); //중복이 끊겼다가 다시 반복되는 경우를 고려해야 함
            }
            cnt += (size%unit); //단위로 나눠 떨어지지 않는 나머지 문자들의 개수 더해줌
            ans = Math.min(ans, cnt);
        }//단위별 계산
        return ans;
    }//Sol
}//Class