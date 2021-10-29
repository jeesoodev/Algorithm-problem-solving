import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        //1. 전체 통틀어 가장 큰 길이를 찾는다. 가로인지 세로인지도 기억.
        int arrSize = sizes.length;
        int max = 0; int index=0; int dir=-1; //가로: 0, 세로: 1
        for(int i=0; i<arrSize; i++){
            if(sizes[i][0] > max){
                max = sizes[i][0]; index = i; dir=0;
            }
            if(sizes[i][1] > max){
                max = sizes[i][1]; index = i; dir=1;
            }
        }        
        
        //2. 해당 명함을 제외하고 Max(남은 명함들의 Min(가로, 세로))를 구한다.
        int subMax = 0;
        for(int i=0; i<arrSize; i++){
            if(i == index) continue;
            subMax = Math.max(subMax, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        //3. 해당 명함의 나머지 길이와도 비교하여 큰 값을 가져온다.
        if(dir==0){
            subMax = Math.max(subMax, sizes[index][1]);
        } else {
            subMax = Math.max(subMax, sizes[index][0]);
        }
        return max*subMax;
    }
}