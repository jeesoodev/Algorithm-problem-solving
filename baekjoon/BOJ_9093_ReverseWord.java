import java.io.*;
import java.util.*;

public class BOJ_9093_ReverseWord {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                int wordSize = word.length();
                if(wordSize>=2){
                    word = reverseWord(word, wordSize);
                }
                sb.append(word).append(" ");
            }
            sb.append("\n");
        }//TC
        System.out.println(sb);
    }//Main

    static String reverseWord(String word, int wordSize){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<wordSize; i++){
            stack.push(word.charAt(i));
        }

        while(stack.size()>0){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}//Class
