import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_BalancedWorld {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if (s.charAt(0)=='.') break;
			
			if (checkBalance(s)) {
				sb.append("yes").append("\n");
			}
			else {
				sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}//Main

	public static boolean checkBalance(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0, size=s.length(); i < size; i++) {
			char cur = s.charAt(i);
			if (cur=='(' || cur=='[') {
				stack.push(cur);
			}
			else {
				if (cur==')') {
					if (stack.isEmpty() || stack.pop()!='(') {
						return false;
					}
				}
				else if (cur==']') {
					if (stack.isEmpty() || stack.pop()!='[') {
						return false;
					}
				}
			}
		}
		
		if (stack.size()!=0) {
			return false;
		}
		return true;
	}//CheckBalance
	

}//Class