import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayDeque<Integer>[] adjList;
	public static int ans = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayDeque[N+1];
		
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayDeque<Integer>();
		}// 인접리스트 생성
		
		for (int i = 0, size = N-1 ; i < size; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
		
		dfs(1, 0, 0);
		System.out.println((ans % 2) == 0 ? "No" : "Yes");
	}

	public static void dfs(int cur, int p, int cnt) {
		for(int next : adjList[cur]) {
			if(next != p) {
				dfs(next, cur, cnt+1);
			}
		}
		
		if(adjList[cur].size() == 1) {
			ans += cnt;
		}
	}//Main
}//Class