import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_PartialSum {

    private static int ans;
    private static int N;
    private static int S;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 수열 입력 받기

        for (int i = 1; i <= N; i++) {
            comb(0, 0, i, 0);
        }
        System.out.println(ans);

    }//Main

    static void comb(int start, int cnt, int r, int sum){
        if (cnt == r){
            if ( sum == S ) ans++;
            return;
        }
        for (int i = start; i < N; i++) {
            comb(i+1, cnt+1 ,r, sum + arr[i] );
        }
    }//comb

}//Class