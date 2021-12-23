// https://www.acmicpc.net/problem/2606
// 바이러스

import java.io.*;
import java.util.*;

public class Main {

	private static boolean[][] comMap;
	private static int virusCnt;
	private static boolean[] visited;
	private static int comNum;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		comNum = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		comMap = new boolean[comNum+1][comNum+1];
		visited = new boolean[comNum+1];
		
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			comMap[from][to] = true;
			comMap[to][from] = true;
		}
		dfs(1);
		System.out.println(virusCnt);
		
	}//Main
	
	static void dfs(int v){
		visited[v]=true;
		
		for (int i = 1; i <= comNum; i++) {
			if (comMap[v][i] && !visited[i]) {
				virusCnt++;
				dfs(i);
			}
		}
	}//dfs
}//Class