import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int sameCnt=0;
        int zeroCnt=0;
        for(int i=0; i<6; i++){
            int n = lottos[i];
            if(n==0) { zeroCnt++; }
            for(int j=0; j<6; j++){
                if(n==win_nums[j]){
                    sameCnt++;
                }
            }
        }
        
        answer[0] = 7-(sameCnt+zeroCnt);
        if(answer[0]==7) answer[0]--;
        if(sameCnt==0) {
            sameCnt++;
        }
        answer[1] = 7-sameCnt;
        
        return answer;
    }
}