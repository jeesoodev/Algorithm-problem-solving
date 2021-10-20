import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1868_Minesweeper {

	private static int N;
	private static int[][] openedMap;
	private static char[][] inputMap;
	private static int dfsCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			inputMap = new char[N][N];
			String s;
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < N; j++) {
					inputMap[i][j] = s.charAt(j);
				}
			}// 지뢰 표 입력 받기
			
			openedMap = new int[N][N];
			int mineCnt = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (inputMap[r][c]=='*') {
						openedMap[r][c]=9; mineCnt++;
					}
					else search(r, c);
				}
			}// 지뢰 표 오픈
			
			
			dfsCnt = 0;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (openedMap[i][j]==0 && !visited[i][j]) {
						dfsCnt++;
						dfs(i,j, visited);
					}
					else if(openedMap[i][j]==9) {
						visited[i][j]=true;
					}
				}
			}
			
			int check = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						check++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dfsCnt+check).append("\n");
		}//TC
		
		System.out.println(sb);
	}//Main

	private static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		
		int nr;
		int nc;
		
		for (int dir = 0; dir < 8; dir++) {
			nr = r + dr[dir];
			nc = c + dc[dir];
			if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
				if (openedMap[nr][nc]==0) {
					dfs(nr, nc, visited);
				}
				else if (openedMap[nr][nc]!=9) {
					visited[nr][nc] = true;
				}
			}
		}
		
	}

	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	private static void search(int r, int c) {
		int nr;
		int nc;
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (nr>=0 && nr<N && nc>=0 && nc<N && inputMap[nr][nc]=='*') {
				cnt++;
			}
		}
		openedMap[r][c] = cnt;
	}
	
}//Class