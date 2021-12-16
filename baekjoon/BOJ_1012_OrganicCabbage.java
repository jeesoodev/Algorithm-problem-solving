// https://www.acmicpc.net/problem/1012
// 유기농 배추

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result;
	static boolean[][] visited;
	static int M;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N][M];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				visited[y][x] = true;
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (visited[r][c]) { 
						dfs(r, c);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
			result = 0;
		}//TC
		
		System.out.println(sb);
		
	}//Main
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			if (0<= nr && nr<N && 0<=nc && nc<M && visited[nr][nc]) {
				visited[nr][nc] = false;
				dfs(nr, nc);
			}
		}
	}
	
}//Class