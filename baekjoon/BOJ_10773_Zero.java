import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_Zero {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<String>();

        String curNum;
        for (int i = 0; i < K; i++) {
            curNum = br.readLine();
            if (curNum.equals("0")) {
                stack.pop();
            }
            else{
                stack.push(curNum);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += Integer.parseInt(stack.pop());
        }

        System.out.println(sum);
    }//Main
}//Class