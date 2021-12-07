// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// 규영이와 인영이의 카드게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static int[] iyCard;
    public static boolean[] isSelected;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
        int[] kyCard;
        for (int t = 1; t <= TC; t++) {
        isSelected = new boolean[20];
        kyCard = new int[9];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < 9; i++) {
            kyCard[i] = Integer.parseInt(st.nextToken());
            isSelected[kyCard[i]] = true;
        }
         
        iyCard = new int[9];
        for (int i = 1,index=0; i <= 18; i++) {
            if (isSelected[i]==false) iyCard[index++]=i;
        }
        int kyScore; int iyScore;
        int winCount=0; int loseCount=0; 
         
        do {
            kyScore=0;  iyScore=0;
            for (int i = 0; i < 9; i++) {
                if (kyCard[i]>iyCard[i]) kyScore += kyCard[i]+iyCard[i];
                else iyScore += kyCard[i]+iyCard[i];
            }
            if (kyScore>iyScore) winCount++;
            else if (kyScore<iyScore) loseCount++;
        }while(np());
            sb.append("#").append(t).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
        }//TC
        System.out.println(sb);
    }// Main
     
    public static boolean np() {
        int i = 8;
        while(i>0 && iyCard[i-1]>=iyCard[i]) i--;
        if (i==0) return false;
         
        int j = 8;
        while(iyCard[i-1]>=iyCard[j]) j--;
        swap(i-1,j);
         
        int k = 8;
        while(i<k)   swap(i++,k--);
        return true;
    }
    public static void swap(int i, int k) {
        int tmp = iyCard[i]; iyCard[i] = iyCard[k]; iyCard[k] = tmp;
    }   
}//Class