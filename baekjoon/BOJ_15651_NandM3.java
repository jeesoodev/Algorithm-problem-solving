import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_NandM3 {
    private static int N;
    private static int M;
    private static int[] numArr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numArr = new int[M];
        permutation(0);
        System.out.println(sb);

    }//Main

    private static void permutation(int cnt){
        if (cnt==M){
            for (int i = 0; i < M; i++) {
                sb.append(numArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            numArr[cnt] = i;
            permutation(cnt+1);
        }
    }//permutation
}//Class
