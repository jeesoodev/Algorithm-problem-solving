//https://programmers.co.kr/learn/courses/30/lessons/43162

import java.io.*;
import java.util.*;

class Solution {
    int[][] map;
    int num;
    
    public int solution(int n, int[][] computers) {
        map = computers;
        num = n;
        int ans=0;
        
        for(int i=0; i<n; i++){
            if(map[i][i]==0) continue;
            ans++; 
            
            for(int j=0; j<n; j++){
                if(map[i][j]==1){
                    map[i][j] = 0;
                    map[j][i] = 0;
                    dfs(j);
                }
            }
        }
        return ans;
    }//Sol
    
    void dfs(int r){
        map[r][r]=0;
        for(int j=0; j<num; j++){
            if(map[r][j]==1 && r!=j){
                map[r][j]=0;
                map[j][r]=0;
                dfs(j);
            }
        }
    }
}//Class