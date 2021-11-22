import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
  
public class Solution {
  
    static int minDiff; // 최소 차이
    static int[][] synergy;
    static int[] dish1; // N/2 개의 숫자
    static int[] dish2;
    static boolean[] isSelected;
    public static int N;
    public static int size;
  
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
  
        StringBuilder sb = new StringBuilder();
  
        for (int t = 1; t <= T; t++) {
            minDiff = Integer.MAX_VALUE;
  
            N = Integer.parseInt(br.readLine());
  
            synergy = new int[N+1][N+1]; // 시너지를 담을 배열 생성
  
            StringTokenizer st;
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int x = 0; x < N; x++) {
                    synergy[y][x]=Integer.parseInt(st.nextToken());
                }
            }
  
            size = N/2;
            isSelected = new boolean[N];
            dish1 = new int[size];
            dish2 = new int[size];
  
            solution(0,0);
  
            sb.append("#").append(t).append(" ").append(minDiff).append("\n");
        }//TC
        System.out.println(sb);
    }//Main
  
    // 각 식재료의  시너지 합을 구하는 메소드
    public static int sumSynergy(int[] dish) {
        int sum=0;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                sum += synergy[dish[i]][dish[j]]+synergy[dish[j]][dish[i]];
            }
        }
        return sum;
    }
  
    public static void solution(int cnt, int start) {
  
        if (cnt == N/2) { // dish 1 완성
            for (int k = 0, index=0; k < size; index++) {
                if (isSelected[index]) continue;
                dish2[k]=index;
                k++;
            }
  
            int diff = sumSynergy(dish1)-sumSynergy(dish2);
            diff = diff<0? diff*(-1): diff;
            minDiff = Math.min(minDiff, diff);
            return;
        }
        for (int i = start; i < N; i++) {
            if (isSelected[i]) continue;
            dish1[cnt]=i;
            isSelected[i]=true;
            solution(cnt+1, i+1);
            isSelected[i]=false; // 코드를 외우지 말자. 처음에 이 부분 안넣어서 오류
        }
    }
  
}//Class