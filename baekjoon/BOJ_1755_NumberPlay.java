import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		String[] match = {"zero", "one", "two", "three", "four", "five",
				"six", "seven", "eight", "nine", "ten"};
		
		ArrayList<String> input = new ArrayList<String>(); // 문자열을 담을 배열 생성
		for (int i = M; i <= N; i++) {
			if (i<=9) {
				input.add(match[i]+i);
			}// 한 자리 숫자일 때. 해당 숫자에 해당하는 문자와 해당 숫자를 문자열로 붙여서 넣는다
			else {
				int n1 = i/10;
				int n2 = i%10;
				input.add(match[n1]+match[n2]+i);
			}// 두 자리 숫자일 때. 각 자리수마다 해당 숫자에 해당하는 문자와 해당 숫자를 문자열로 붙여서 넣는다
		}
		
		Collections.sort(input); // 문자열을 정렬

		int numCnt=0; // 한 줄에 10개 출력하기 위해 숫자 카운트해주는 변수
		
		for (int i = 0, size = input.size(); i < size; i++) {
			String s = input.get(i); // 문자열을 하나씩 꺼내오기
			for (int j = 0, size2 = s.length(); j < size2; j++) {
				char c = s.charAt(j); // 문자열을 문자로 쪼개어서
				if (Character.isDigit(c)) { // 그 문자가 숫자인지 판단 숫자면 sb에 넣어주기
					sb.append(c);
				}
			}
			sb.append(" "); // 숫자 한 단위 넣고 띄어쓰기
			numCnt++;
			if (numCnt==10) { // 10개 숫자 쓰면 
				sb.append("\n"); // enter쳐주고
				numCnt=0; // 초기화
			}
		}
		System.out.println(sb);
	}//Main
}//Class