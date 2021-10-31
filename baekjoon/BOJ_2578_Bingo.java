//https://www.acmicpc.net/problem/2578
//빙고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2578_Bingo{

	public static int[][] board;
	public static int bingoCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[5][5];
		
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int callNum = 0;
		int count=0;
		int bingoNum=0;
		
dirr:	for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				callNum = Integer.parseInt(st.nextToken());
				bingoNum++;
				removeNum(callNum);
				count++;
				if (count >= 12) {
					bingoCount=0;
					checkBingo();
					if (bingoCount >= 3) {
						System.out.println(bingoNum);
						break dirr;
					}
				}
			}
		}
		
	}//Main
	public static void removeNum(int callNum) {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (board[r][c]==callNum) {
					board[r][c]=0;
					return;
				}
			}
		}
	}
	
	public static void checkBingo() {
		for (int c = 0; c < 5; c++) {
			if (board[0][c]!=0) break;
			if (c==4) {
				bingoCount++;
			}
		}
		for (int c = 0; c < 5; c++) {
			if (board[1][c]!=0) break;
			if (c==4) {
				bingoCount++;
			}
		}
		for (int c = 0; c < 5; c++) {
			if (board[2][c]!=0) break;
			if (c==4) {
				bingoCount++;
			}
		}
		for (int c = 0; c < 5; c++) {
			if (board[3][c]!=0) break;
			if (c==4) {
				bingoCount++;
			}
		}
		for (int c = 0; c < 5; c++) {
			if (board[4][c]!=0) break;
			if (c==4) {
				bingoCount++;
			}
		}
		for (int r = 0; r < 5; r++) {
			if (board[r][0]!=0) break;
			if (r==4) {
				bingoCount++;
			}
		}
		for (int r = 0; r < 5; r++) {
			if (board[r][1]!=0) break;
			if (r==4) {
				bingoCount++;
			}
		}
		for (int r = 0; r < 5; r++) {
			if (board[r][2]!=0) break;
			if (r==4) {
				bingoCount++;
			}
		}
		for (int r = 0; r < 5; r++) {
			if (board[r][3]!=0) break;
			if (r==4) {
				bingoCount++;
			}
		}
		for (int r = 0; r < 5; r++) {
			if (board[r][4]!=0) break;
			if (r==4) {
				bingoCount++;
			}
		}
		if (board[0][0]==0 && board[1][1]==0 && board[2][2]==0
				&& board[3][3]==0 && board[4][4]==0) {
			bingoCount++;
		}
		if (board[0][4]==0 && board[1][3]==0 && board[2][2]==0
				&& board[3][1]==0 && board[4][0]==0) {
			bingoCount++;
		}
		return;
	}
}//Class
