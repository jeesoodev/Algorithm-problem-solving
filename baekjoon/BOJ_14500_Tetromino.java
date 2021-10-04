import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_Tetromino {

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
            }
        }//위치마다 dfs 탐색

        exception();
        System.out.println(max);
    }//Main


    static int[] dirR = {-1, 0, 1, 0};
    static int[] dirC = {0, -1, 0, 1};

    static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == 3) {
            if (sum > max) {
                max = sum;
            }
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

    static void exception() {
        int sum=0;

        // 1. ㅏ
        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                sum = map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j+1];
                if(sum > max){
                    max = sum;
                };
            }
        }
        // 2. ㅓ
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M; j++) {
                sum = map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1];
                if(sum > max){
                    max = sum;
                };
            }
        }
        // 3. ㅗ
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M-1; j++) {
                sum = map[i][j]+map[i][j-1]+map[i][j+1]+map[i-1][j];
                if(sum > max){
                    max = sum;
                };
            }
        }
        // 4. ㅜ
        for (int i = 0; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                sum = map[i][j]+map[i][j-1]+map[i][j+1]+map[i+1][j];
                if(sum > max){
                    max = sum;
                };
            }
        }
    }//Exception

}//Class
