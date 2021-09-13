import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_PrefixSum4 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }// 숫자 입력 받기

        int[] prefixSumArr = new int[N+1];
        int sum=0;
        for (int i = 1; i <= N; i++) {
            sum = prefixSumArr[i] = sum + numArr[i];
        }//구간 합 배열

        int from=0; int to=0;
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            sb.append(prefixSumArr[to]-prefixSumArr[from-1]).append("\n");
        }//TC

        System.out.println(sb);
    }//Main
}//Class
