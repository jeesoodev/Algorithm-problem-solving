// https://programmers.co.kr/learn/courses/30/lessons/81302
// 거리두기 확인하기

import java.io.*;
import java.util.*;

class Solution {
    
    class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    char[][] room = new char[5][5];
    boolean flag = false;
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        
        Queue<Point> queue = new LinkedList<>();
        for(int tc=0; tc<5; tc++){
            flag = false;
            for(int i=0; i<5; i++){
                String s = places[tc][i];
                for(int j=0; j<5; j++){
                    char c = s.charAt(j);
                    room[i][j] = c;
                    if(c=='P'){
                        queue.add(new Point(i,j)); // 사람이 있는 위치 queue에 넣어주기
                    }
                }
            }// room 입력하기
                 
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                Point p = queue.poll();
                room[p.r][p.c]='O';
                dfs(p.r, p.c, 0);
                if(flag) {
                    break;
                }
            }
            
            if(flag) ans[tc] = 0;
            else ans[tc] = 1;
            queue.clear(); // queue를 안비워줘서 처음에 답이 이상하게 나왔었음.
            
        }//5개 방에 대해 검사
        
        return ans;
    }
    
    int[] dirR = {-1, 0, 1, 0};
    int[] dirC = {0, -1, 0, 1};
    
    void dfs(int r, int c, int cnt){
        if(cnt == 2){
            if(room[r][c]=='P'){
                flag = true;
            }
            return;
        }
        
        if(flag) return;
        
        for(int d=0; d<4; d++){
            int nr = r+dirR[d];
            int nc = c+dirC[d];
            if(0<=nr && nr<5 && 0<=nc && nc<5 && room[nr][nc]=='P'){
                flag = true;
                System.out.println("nr: "+nr+", nc: "+nc);
                break; //여기 모르겠음ㅠㅠ return을 써야하는건가
            }
            else if(0<=nr && nr<5 && 0<=nc && nc<5 && room[nr][nc]=='O'){
                dfs(nr, nc, cnt+1);
            }
        }
    }
    
}//Class