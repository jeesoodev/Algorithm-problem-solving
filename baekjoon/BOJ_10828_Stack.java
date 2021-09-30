import java.io.*;
import java.util.*;

public class BOJ_10828_Stack {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(s.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if(s.equals("size")){
                sb.append(stack.size()).append("\n");
            } else if(s.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1).append("\n");
                } else{
                    sb.append(0).append("\n");
                }
            } else if(s.equals("top")){
                if(!stack.isEmpty()){
                    sb.append(stack.peek()).append("\n");
                } else{
                    sb.append(-1).append("\n");
                }
            }

        }//N만큼 반복

        System.out.println(sb);

    }//Main
}//Class

