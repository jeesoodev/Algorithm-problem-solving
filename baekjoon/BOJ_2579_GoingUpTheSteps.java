import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_GoingUpTheSteps {
    private static int N;
    private static int[] steps;
    private static int[][] maxSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        steps = new int[N+1];
        maxSum = new int[2][N+1];
        for (int i = 1; i <= N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, 0);
        System.out.println(Math.max(maxSum[0][N], maxSum[1][N]));
    }//Main

    private static void dfs(int loc, int cnt, int tmpScore) {
        if (loc == N){
            return;
        }

        if (cnt!=2 && loc < N){
            if(maxSum[0][loc+1] < tmpScore+steps[loc+1]){
                maxSum[0][loc+1] = tmpScore+steps[loc+1];
                dfs(loc+1, cnt+1, tmpScore+steps[loc+1]);
            }
        }
        if (loc < N-1){
            if(maxSum[1][loc+2] < tmpScore+steps[loc+2]){
                maxSum[1][loc+2] = tmpScore+steps[loc+2];
                dfs(loc+2, 1, tmpScore+steps[loc+2]);
            }
        }

    }//dfs
}//Class
