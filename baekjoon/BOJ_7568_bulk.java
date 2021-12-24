import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] infoArr = new int[N][2]; // 키와 몸무게를 담을 2차원 배열
		
		int cnt=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			infoArr[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			infoArr[i][1] = Integer.parseInt(st.nextToken()); // 키
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (infoArr[i][0]<infoArr[j][0] && infoArr[i][1]<infoArr[j][1]) {
					cnt++;
				}
			}
			sb.append((cnt+1)+" ");
			cnt = 0;
		}
		
		System.out.println(sb);
		
	}//Main
}//Class