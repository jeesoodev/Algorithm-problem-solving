//https://programmers.co.kr/learn/courses/30/lessons/49189
//가장 먼 노드

import java.io.*;
import java.util.*;

class Solution {
    
    boolean[][] link; //연결 정보
    boolean[] visited; //방문 체크
    Integer[] dArr; //1부터 index까지의 거리를 담는 배열
    
    public int solution(int n, int[][] edge) {
        int ans = 0;
        
        visited = new boolean[n+1];
        dArr = new Integer[n+1];
        
        link = new boolean[n+1][n+1];
        for(int i=0, size=edge.length; i<size; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            link[from][to] = link[to][from] = true; 
        }

        
        Arrays.fill(dArr, 0); //처음에 이 부분 안넣어줘서 NullPointerException났음. dArr[0], dArr[1]에 값이 없는데 정렬하려고 하니 이런 에러 발생
        // dArr[0] = dArr[1] = 0; 이거 써도 됨
        
        bfs(n);
        Arrays.sort(dArr, Collections.reverseOrder()); //내림차순 정렬
        int max = dArr[0];
        for(int i=0; i<=n+1; i++){
            if(dArr[i]==max) ans++;
            else break;
        }
        return ans;
    }
    
    void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(1);
        int depth = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){ 
                int num = queue.poll();
                
                for(int i=1; i<=n; i++){
                    if(link[num][i] && !visited[i]){
                        visited[i] = true;
                        dArr[i]=depth; //거리 저장
                        queue.offer(i);
                    }
                }     
            }// queue 사이즈만큼 연결된 노드 삽입
            
            depth++;
        }//queue가 빌 때까지 반복
    }//bfs
}

/*
1. 연결 정보를 2차원 boolean 배열에 담기
2. bfs를 사용해서 1에서 특정 노드까지 가는 최단 거리 구하기
3. 최단 거리를 담은 dArr 배열을 정렬하여 몇 개 있는지 체크
*/