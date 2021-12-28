import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 원본 배열 입력 받기
		
		int[][] sumArr = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] + arr[i][j] - sumArr[i-1][j-1];
			}
		}
		
		int x1, y1, x2, y2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sb.append(sumArr[x2][y2]-sumArr[x2][y1-1]-sumArr[x1-1][y2]+sumArr[x1-1][y1-1]).append("\n");
		}
	
		System.out.println(sb);
	}//Main
}//Class