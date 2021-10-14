import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[][] link;
    static boolean[][] visited;
    static int cnt=1;
    static int num;
    
    public int solution(int n, int[][] wires) {
        
        int answer = 999999999;
        num = n;
        
        link = new boolean[n+1][n+1]; // 연결 정보
        for(int i=0, size=n-1; i<size; i++){
            int r = wires[i][0];
            int c = wires[i][1];
            link[r][c] = link[c][r] = true;
        }
        
        for(int i=0; i<n-1; i++){
            visited = new boolean[n+1][n+1];
            int r = wires[i][0];
            int c = wires[i][1];
            link[r][c]=link[c][r]=false;  
            
            dfs(1);
            answer = Math.min(answer, compare(cnt));

            link[r][c]=link[c][r]=true;
            cnt = 1;
            
        }//연결 하나씩 제거해보기
        
        return answer;
    }
    
    static void dfs(int n){
        for(int i=1; i<=num; i++){
            if(link[n][i] && !visited[n][i]){
                cnt++;
                visited[n][i]=visited[i][n] = true;
                dfs(i);
            }
        }
    }
    
    static int compare(int cnt){
        int remain = num-cnt;
        return Math.abs(remain-cnt);
    }//차이 계산
}