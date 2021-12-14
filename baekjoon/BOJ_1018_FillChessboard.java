// https://www.acmicpc.net/problem/1018
// 체스판 다시 칠하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] board;
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		
		board = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < N-8+1; i++) {
			for (int j = 0; j < M-8+1; j++) {
				minfunc(i, j);
			}
		}
		
		System.out.println(minCnt);
	}
	
	static void minfunc(int y, int x) {
		int partMin=0;
		char flag = 'W';
		for (int i = y, ly = y+8; i < ly; i++) {
			for (int j = x, lx = x+8; j < lx; j++) {
				if (board[i][j]!=flag) {
					partMin++;
				}
				if (flag=='W') flag='B';
				else flag='W';
			}
			if (flag=='W') flag='B';
			else flag='W';
		}
		minCnt = Math.min(minCnt, partMin);
		
		partMin=0;
		flag = 'B';
		for (int i = y, ly = y+8; i < ly; i++) {
			for (int j = x, lx = x+8; j < lx; j++) {
				if (board[i][j]!=flag) {
					partMin++;
				}
				if (flag=='W') flag='B';
				else flag='W';
			}
			if (flag=='W') flag='B';
			else flag='W';
		}
		minCnt = Math.min(minCnt, partMin);
		
	}
}