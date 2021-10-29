// https://www.acmicpc.net/source/34882296
// 회문

import java.io.*;
import java.util.*;

public class BOJ_17609_Palindrome {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; tc++){
            String s = br.readLine();
            
            // 양쪽 끝에서 출발. 두 개가 다르다면 왼쪽 삭제 or 오른쪽 삭제
            int sSize = s.length();
            boolean flag = true; // 회문
            for(int i=0, j=sSize-1; i<sSize && i<=j; i++, j--){
                if(s.charAt(i) != s.charAt(j)){
                    boolean flagL = check(s, i+1, j); // 왼쪽 삭제
                    boolean flagR = check(s, i, j-1); // 오른쪽 삭제
                    if(flagL || flagR) sb.append(1);
                    else sb.append(2);
                    flag = false;
                    break;
                }
            }
            
            if(flag) sb.append(0);
            sb.append("\n");
        }//TC
        System.out.println(sb);

	}//Main
    
    static boolean check(String s, int i, int j){
        int sSize = s.length();
        for(int a=i, b=j; a<sSize && a<=b; a++,b--){
            if(s.charAt(a) != s.charAt(b)){
                return false;
            }
        }
        return true;
    }

}//Class