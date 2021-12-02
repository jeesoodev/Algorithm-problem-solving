// https://programmers.co.kr/learn/courses/30/lessons/1829
// 카카오프렌즈 컬러링북

import java.io.*;
import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[][] map;
    int M, N;
    int cnt;
    
    public int[] solution(int m, int n, int[][] picture) {
        int totalAreaCnt = 0;
        int max = 0;
        
        visited = new boolean[m][n];
            
        map = picture;
        M = m; N = n;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    visited[i][j] = true;
                    totalAreaCnt++;
                    cnt = 1;
                    dfs(new int[]{i, j}, picture[i][j]); // 위치와 색상 번호
                    max = Math.max(cnt, max);
                }
            }
        }
             
        int[] answer = new int[2];
        answer[0] = totalAreaCnt;
        answer[1] = max;
        return answer;
    }//Sol
    
    
    int[] dirR = {-1, 0, 1, 0};
    int[] dirC = {0, -1, 0, 1};
    
    void dfs(int[] point, int color){

        for(int d=0; d<4; d++){
            int nr = point[0] + dirR[d];
            int nc = point[1] + dirC[d];
            if(0<=nr && nr<M && 0<=nc && nc<N && !visited[nr][nc] && map[nr][nc]==color){
                cnt++;
                visited[nr][nc] = true;
                dfs(new int[]{nr,nc}, color);
            }
        }
        
    }//dfs
    
}//Class