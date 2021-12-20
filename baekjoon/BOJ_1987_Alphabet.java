// https://www.acmicpc.net/problem/1987
// 알파벳

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int maxCount=1;
	public static int R;
	public static int C;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int y = 0; y < R; y++) {
			String line = br.readLine();
			for (int x = 0; x < C; x++) {
				map[y][x]=line.charAt(x);
			}
		}
		
		isSelected = new boolean[26];
		isSelected[map[0][0]-'A']=true;
		
		dfs(0,0,1);
		
		System.out.println(maxCount);

		
	}//Main

	static int[] dy= {0,1,0,-1}; // 우, 하, 좌, 상
	static int[] dx= {1,0,-1,0}; // 우, 하, 좌, 상

	public static void dfs(int y, int x, int cnt) {
		
		if (cnt>maxCount) {
			maxCount = cnt;
		}
		
		for (int dir = 0; dir < 4; dir++) {
			int ny = y+dy[dir];
			int nx = x+dx[dir];
			if (ny<0 || ny>= R || nx<0 || nx>=C || isSelected[map[ny][nx]-'A']) { // 범위를 벗어나거나 이미 선택된 알파벳이면 continue
				continue;
			}
			isSelected[map[ny][nx]-'A']=true;
			dfs(ny, nx, cnt+1);
		}
		isSelected[map[y][x]-'A']=false;
		return;
	}

}//Class