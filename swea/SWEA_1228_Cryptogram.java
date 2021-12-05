// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
// 암호문

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        LinkedList<String> codes;
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringTokenizer st2;
        StringBuilder sb = new StringBuilder();
         
         
        for (int testcase = 1; testcase <= 10; testcase++) {
            int N = Integer.parseInt(br.readLine());
             
            codes = new LinkedList<String>();
             
            st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < N; i++) {
                codes.addLast(st.nextToken());
            }
             
            int R = Integer.parseInt(br.readLine());
             
            st = new StringTokenizer(br.readLine(),"I");
            for (int i = 0; i < R; i++) {
                 
                String s = st.nextToken();
                st2 = new StringTokenizer(s," ");
                int index = Integer.parseInt(st2.nextToken());
                int cnt = Integer.parseInt(st2.nextToken());
                for (int j = 0; j < cnt; j++,index++) {
                    codes.add(index, st2.nextToken());
                }
            }
             
            sb.append("#").append(testcase).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(codes.get(i)).append(" ");
            }
            sb.append("\n");
        }//TC
        System.out.println(sb);
    }//Main
}//Class