import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_TurnArray1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		
		
		int[][] map = new int[N][M];
		int tmp, lastR=N-1, lastC=M-1;
		
		for (int turnCnt = 0; turnCnt < R; turnCnt++) {
			for (int i = 0, size = (Math.min(N,M)/2); i < size; i++) {
				tmp = map[i][i];
				
				// 윗줄 한 칸씩 왼쪽으로 이동
				for (int c = i; c < lastC; c++) {
					map[i][c] = map[i][c+1];
				}
				
				// 오른쪽 줄 한 칸씩 위쪽으로 이동
				for (int r = i; r < lastR; r++) {
					map[r][lastC] = map[r+1][lastC];
				}
				
				// 아랫줄 한 칸씩 오른쪽으로 이동
				for (int c = lastC; c > 0; c--) {
					map[lastR][c-1] = map[lastR][c];
				}
				
				// 왼쪽줄 한 칸씩 아래쪽으로 이동
				for (int r = lastR; r > 0; r--) {
					map[r][i] = map[r-1][i];
				}
			}
		}//Turn
		
		System.out.println("==");
		
	}//Main

}//Class