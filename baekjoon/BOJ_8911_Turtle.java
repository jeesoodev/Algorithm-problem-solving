//https://www.acmicpc.net/problem/8911

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sql.rowset.CachedRowSet;

public class BOJ_8911_Turtle{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int up;
		int down;
		int left;
		int right;
		int curR;
		int curC;
		
		char[] direction = {'u', 'r', 'd', 'l'};
		
		for (int tc = 0; tc < T; tc++) {
			up = 0;
			down = 0;
			left = 0;
			right = 0;
			
			curR = 0;
			curC = 0;
			
			char curDir = 'u'; // 맨 처음에는 북쪽 방향을 향함
			int curD = 0;
			
			String act = br.readLine();
			for (int i = 0, size = act.length(); i < size; i++) {
				char c = act.charAt(i);
				switch (c) {
				case 'F':
					switch (curDir) {
					case 'u':
						if (++curR > up) up = curR; break;
					case 'r':
						if (++curC > right) right = curC; break;
					case 'd':
						if (--curR < down) down = curR; break;
					case 'l':
						if (--curC < left) left = curC; break;
					}
					break;
				case 'B':
					switch (curDir) {
					case 'u':
						if (--curR < down) down = curR; break;
					case 'r':
						if (--curC < left) left = curC; break;
					case 'd':
						if (++curR > up) up = curR; break;
					case 'l':
						if (++curC > right) right = curC; break;
					}
					break;
				case 'L':
					if (curD-1>=0) curDir = direction[--curD];
					else {
						curDir = 'l';
						curD = 3;
					}
					break;
				case 'R':
					if (curD+1<=3) curDir = direction[++curD];
					else {
						curDir = 'u';
						curD = 0;
					}
					break;
				}
			}
			sb.append((right-left)*(up-down)).append("\n");
		}//TC
		System.out.println(sb);
	}//Main

}//Class
