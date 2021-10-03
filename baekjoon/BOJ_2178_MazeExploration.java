import java.io.*;
import java.util.*;

public class BOJ_2178_MazeExploration{
    
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j]=s.charAt(j);
            }
        }//Map에 입력 받기
        
        int ans = bfs(0,0);
        System.out.println(ans+1);

	}//Main
    
    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, -1, 0, 1};
    public static int bfs(int startR, int startC){
        int ans=0;
        Queue<int[]> queue = new LinkedList<>();
        visited[startR][startC] = true;
        queue.add(new int[] {startR,startC});
        
        int locN = N-1; int locM = M-1;
        
        while(!queue.isEmpty()){
            int size = queue.size();            
            
            while(size-- >0){
                int[] point = queue.poll();
                int r = point[0]; int c = point[1];
                
                if(r==locN && c==locM){
                    return ans;
                }
                
                for(int d=0; d<4; d++){
                    int nr = r+dirR[d];
                    int nc = c+dirC[d];
                    if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc] && map[nr][nc]=='1'){
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            ans++;
        }
        return ans;
    }//bfs
}//Class