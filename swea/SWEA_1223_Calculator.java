// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD
// 계산기2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= 10; tc++) {
 
            int N = Integer.parseInt(br.readLine());
 
            char[] c = br.readLine().toCharArray();
 
            ArrayList<Character> cal = new ArrayList<Character>();
            Stack<Character> op = new Stack<Character>();
 
            for (int i = 0, size = c.length; i < size; i++) {
                if (c[i] == '+') {
                    if (op.isEmpty())
                        op.push(c[i]);
                    else {
                        while (!op.isEmpty()) {
                            cal.add(op.pop());
                        }
                        op.push(c[i]);
                    }
                } else if (c[i] == '*') {
                    if (!op.isEmpty()) {
                        if (op.peek() == '+') {
                            op.push(c[i]);
                        } else {
                            cal.add(op.pop());
                            op.push(c[i]);
                        }
                    }
                    else {
                        op.push(c[i]);
                    }
                } else {
                    cal.add(c[i]);
                }
            }
            while (!op.isEmpty()) {
                cal.add(op.pop());
            }
 
            Stack<Integer> result = new Stack<Integer>();
 
            int n1 = 0;
            int n2 = 0;
            for (int i = 0, size = cal.size(); i < size; i++) {
                if (cal.get(i) == '+') {
                    n1 = result.pop();
                    n2 = result.pop();
                    result.push(n2 + n1);
                } else if (cal.get(i) == '*') {
                    n1 = result.pop();
                    n2 = result.pop();
                    result.push(n2 * n1);
                } else {
                    result.push(cal.get(i) - '0');
                }
            }
             
            sb.append("#").append(tc).append(" ").append(result.pop()).append("\n");
        }//TC
         
        System.out.println(sb);
    }//Main
}//Class
