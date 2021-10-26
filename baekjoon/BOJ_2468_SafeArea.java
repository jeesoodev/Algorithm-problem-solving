import java.io.*;
import java.util.*;

public class BOJ_2468_SafeArea{
    
    static int N, min, max;
    static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            st  = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                min = Math.min(min, tmp);
                max = Math.max(max, tmp);
            }
        }//입력받기
        
        int ans=1;
        for(int k=min; k<max; k++){
            boolean[][] selected = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!selected[i][j] && k < map[i][j]){
                        selected[i][j] = true;
                        dfs(selected, k, i, j);
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
        
        
        
	}//Main
    
    static int[] dirR = {-1,0,1,0};
    static int[] dirC = {0,-1,0,1};
    
    static void dfs(boolean[][] selected, int k, int r, int c){
        
        for(int d=0; d<4; d++){
            int nr = r + dirR[d];
            int nc = c + dirC[d];
            
            if(0<=nr && nr<N && 0<=nc && nc<N && k<map[nr][nc] && !selected[nr][nc]){
                selected[nr][nc] = true;
                dfs(selected, k, nr, nc);
            }
        }
    }//dfs
}//Class
