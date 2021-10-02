import java.io.*;
import java.util.*;

public class BOJ_9093_ReverseWord_2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        while(T-- > 0){
            char[] sentence = (br.readLine()+"\n").toCharArray();
            for(char c : sentence){
                if (c==' ' || c=='\n'){
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }//TC
        System.out.println(sb);
    }//Main
}//Class
