import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_CrazyRobot {

    private static boolean[][] visited = new boolean[30][30]; // 방문 체크와 동시에 이동
    private static double ans;

    private static int N;
    private static double ep;
    private static double wp;
    private static double sp;
    private static double np;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            pArr[i] = Double.parseDouble(st.nextToken())/100;
        }

        visited[15][15] = true;
        dfs(15,15,0,1);
        System.out.println(ans);

    }//Main

    private static int[] dirR = {-1,0,1,0};
    private static int[] dirC = {0,-1,0,1};;
    private static double[] pArr = new double[4]; // 네 방향 확률
    private static void dfs(int r, int c, int cnt, double p) {
        if(cnt == N){
            ans += p; return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r+dirR[d];
            int nc = c+dirC[d];
            if (0<=nr && nr<29 && 0<=nc && nc<=29 && !visited[nr][nc]){
                visited[nr][nc]=true;
                dfs(nr, nc, cnt+1, p*(pArr[d]));
                visited[nr][nc]=false;
            }
        }
    }//dfs

}//Class
