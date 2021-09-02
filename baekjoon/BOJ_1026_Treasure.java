import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026_Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N]; Integer[] B = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }// A 입력 받기
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }// B 입력 받기

        int S=0;
        Arrays.sort(A); // 오름차순 배열 정렬
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순 배열 정렬

        for (int i = 0; i < N; i++) {
            S += (A[i]*B[i]);
        }// 최소 합 구하기

        System.out.println(S);
    }//Main
}//Class
