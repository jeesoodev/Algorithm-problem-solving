import java.io.*;
import java.util.*;

public class BOJ_1874_StackSequence {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int latestNum = 0;
        Stack<Integer> stack = new Stack<>();
        while(N-- > 0){
            int targetNum = Integer.parseInt(br.readLine()); // 수열 구성 숫자
            while(latestNum < targetNum){
                stack.push(++latestNum);
                sb.append("+").append("\n");
            }

            boolean flag = true;
            while(!stack.isEmpty()){
                if( stack.pop() == targetNum ){
                    sb.append("-").append("\n");
                    flag = false; break;
                }
            }

            if (flag){ // stack에서 계속 pop 했음에도 해당 숫자가 없다는 것 -> 수열을 만들 수 없음
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }
            System.out.println(sb);
    }
}//Classs
