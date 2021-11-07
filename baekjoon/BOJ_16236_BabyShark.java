package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16236_BabyShark {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int sharkSize = 2; // 상어의 초기 크기
	static int eat; // 상어가 잡아먹은 물고기 수
	static int move; // 상어가 움직인 최소 거리(구하고자 하는 값)
	static int tempMove; // 상어가 움직이는 거리를 임시 저장. 움직일 때마다 카운트 하면서 실제로 물고기를 먹었을 때 move 변수에 반영해 줌.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0, index=0; j < N; j++, index+=2) {
				map[i][j] = s.charAt(index)-'0';
				if (map[i][j]==9) {
					queue.offer(new int[]{i,j}); // 맨 처음 상어의 출발지를 queue에 삽입
					visited[i][j] = true;
					map[i][j] = 0;
				}
			}
		}
		
		bfs();
		while(flag) {
			queue.offer(new int[]{ansR,ansC});
			bfs();
		}		
		
		System.out.println(move);
		
	}//Main
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static boolean flag; // 물고기를 먹었는지 여부
	
	// 최종적으로 먹은 물고기의 행과 열
	static int ansR; 
	static int ansC;
	
	static void bfs() {
		flag=false; // 새로 물고기를 먹기 위해 시작하므로 물고기를 먹지 않은 상태인 false로 초기화
		ansR = Integer.MAX_VALUE;
		ansC = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			int level = queue.size();
			
			while(level>0) { // 같은 레벨 단위 처리
				int[] current = queue.poll(); 
				int r = current[0]; 
				int c = current[1];
				if (map[r][c] !=0 && map[r][c] < sharkSize) { // 상어보다 작은 크기의 물고기 발견
					flag = true; // 먹을 수 있는 물고기 대상이 있으니 true로 체크
					if (ansR != r && ansR > r) { // 더 위에 있는 물고기의 우선순위가 높으므로 먼저 체크
						ansR = r; ansC = c;
					}
					else if(ansR == r && ansC > c) { // 높이가 같을 때는 더 왼쪽에 있는 물고기의 우선순위가 높음
						ansR = r; ansC = c;
					}
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] 
						&& map[nr][nc]<=sharkSize){
						queue.offer(new int[]{nr,nc});
						visited[nr][nc]=true;
					}
				}// 4방 탐색해서 queue에 삽입
				
				level--;
				
			}// 동일 level 작업
			
			// level 단위 작업이 끝난 후, 해당 레벨에서 먹을 수 있는 물고기가 있었다면 먹기
			if (flag) {
				eat++;
				move += tempMove; // 움직인 횟수 더해줌
				tempMove=0;
				map[ansR][ansC] = 0;
				visited = new boolean[N][N];
				visited[ansR][ansC] = true;
				queue.clear();
				if (eat == sharkSize) {
					eat = 0;
					sharkSize++;
				}
			}
			else { tempMove++; } // 먹을 물고기가 없으니 다시 이동
			
		}// queue에 값이 있을 때만
	}//bfs
}//Class