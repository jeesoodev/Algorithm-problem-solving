import java.io.*;
import java.util.*;

public class BOJ_15652_NandM4{
    
    private static StringBuilder sb;
    private static int N, M;
    private static int[] arr;
    
    public static void main(String args[]) throws IOException{
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        permutation(1, 0);
        System.out.println(sb);
    }//Main
    
    private static void permutation(int start, int cnt){
        if(cnt==M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n"); return;
        }
        for(int i=start; i<=N; i++){
            arr[cnt] = i;
            permutation(i, cnt+1);
        }
    }
}//Class