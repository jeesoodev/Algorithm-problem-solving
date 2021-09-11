import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_NandM {

    private static int N;
    private static int M;
    private static boolean[] selected; // 선택 됐는지 체크
    private static int[] arr; // 선택된 숫자를 담을 배열
    private static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new boolean[N+1];
        arr = new int[M];

        comb(0);
        System.out.println(sb);
    }//Main

    private static void comb(int cnt){
        if (cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected[i]){
            selected[i] = true; // 선택
            arr[cnt] = i; // 배열에 담기
            comb(cnt+1); // 다음 위치 뽑기
            selected[i] = false; // 선택 해제
            }
        }
    }//Comb
}//Class