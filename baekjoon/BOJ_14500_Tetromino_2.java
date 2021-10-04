import java.io.*;
import java.util.*;

public class BOJ_14500_Tetromino_2 {

    private static int max;
    private static int[][] map;
    private static boolean[][] visited;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력 받기

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j]=true;
                dfs(i,j, 0, map[i][j]);
                visited[i][j]=false;
                checkException(i, j);
            }
        }//위치마다 dfs 탐색, 예외 체크
        System.out.println(max);
    }//Main


    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, -1, 0, 1};
    static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == 3) {
            max = Math.max(sum, max);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = r + dirR[d];
            int nc = c + dirC[d];
            if (0<=ny && ny<N && 0<=nc && nc<M && !visited[ny][nc]){
                visited[ny][nc]=true;
                dfs(ny, nc, cnt+1, sum+map[ny][nc]);
                visited[ny][nc]=false;
            }
        }
    }

    static void checkException(int i, int j) {
        int sum=0;

        if (1<=i && i <N-1 && 0<=j && j<M-1){
            max = Math.max(max, map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j+1]);
        } //1. ㅏ
        if (1<=i && i <N-1 && 1<=j && j<M){
            max = Math.max(max, map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1]);
        } //2. ㅓ
        if (1<=i && i <N && 1<=j && j<M-1){
            max = Math.max(max, map[i][j]+map[i][j-1]+map[i][j+1]+map[i-1][j]);
        } //3. ㅗ
        if (0<=i && i <N-1 && 1<=j && j<M-1){
            max = Math.max(max, map[i][j]+map[i][j-1]+map[i][j+1]+map[i+1][j]);
        } //4. ㅜ

    }//checkException

}//Class
