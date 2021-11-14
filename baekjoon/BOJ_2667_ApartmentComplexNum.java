import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static int N;
	public static int[][] map;
	static int num = 2; // 단지 번호
	static int cnt; // 아파트 개수
	static ArrayList<Integer> cntArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringBuilder sb = new StringBuilder();
		
		cntArr = new ArrayList<Integer>();
		
		// 배열 입력 받기
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		// 배열을 쭉 돌면서 번호 매기기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]==1) {
					dfs(i, j);
					num++;
					cntArr.add(cnt);
					cnt = 0;
				}
			}
		}
		
		sb.append(num-2).append("\n");
		
		Collections.sort(cntArr);
		for (int i = 0, size = cntArr.size(); i < size; i++) {
			sb.append(cntArr.get(i)).append("\n");
		}
		System.out.println(sb);
	}//Main

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void dfs(int r, int c) {
		map[r][c] = num; //아파트에 단지 번호 붙여주기
		cnt++; // 아파트 개수 세기
		
		//사방 탐색
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
	}//dfs
}//Class