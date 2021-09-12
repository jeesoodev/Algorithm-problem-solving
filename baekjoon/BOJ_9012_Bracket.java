import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Stack;

public class BOJ_9012_Bracket {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack;
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            stack = new Stack<>();

            boolean flag = true;
            for (int i = 0, size=s.length(); i < size; i++) {
                if (s.charAt(i)=='('){
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        flag=false; break;
                    }
                    stack.pop();
                }
            }//문자열 길이만큼 반복
            if (!stack.isEmpty()) flag=false;

            if (flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }//TC
        System.out.println(sb);
    }//Main
}//Class
