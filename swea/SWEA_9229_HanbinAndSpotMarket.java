import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int R = 2;
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static int maxSum;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int TC = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= TC; testcase++) {
            maxSum=-1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            arr = new int[N];
            result = new int[R];
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
             
            maxweight(0, 0);
            sb.append("#").append(testcase).append(" ").append(maxSum).append("\n");
        }//TC
        System.out.println(sb);
         
         
    }//Main
     
    private static void maxweight(int cnt, int start) {
        int sum = 0;
        if (cnt==R) {
            sum=result[0]+result[1];
            if (sum>maxSum && sum<=M) {
                maxSum=sum;
            }
            return;
        }
        for (int i = start; i < N; i++) {
            result[cnt]=arr[i];
            maxweight(cnt+1, i+1);
        }
    }
}