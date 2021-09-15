import java.io.*;
import java.util.*;

public class BOJ_15650_NandM2 {

    private static StringBuilder sb;
    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String args[]) throws IOException{
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        comb(1, 0);
        System.out.println(sb);

    }//Main

    private static void comb(int start, int cnt){
        if(cnt==M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=N; i++){
            arr[cnt] = i;
            comb(i+1, cnt+1);
        }
    }//조합

}//Class