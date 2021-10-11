import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_SetRepresentation {
	
	static int N;
	static int[] Parents;
	
	static void make() {
		for (int i = 0; i <= N; i++) {
			Parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (Parents[a] == a) return a;
		return Parents[a] = findSet(Parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		Parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Parents = new int[N+1]; // 대표자 배열 생성
		make();
		
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int flag = Integer.parseInt(st.nextToken());
			if (flag == 0) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			else if (flag == 1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (findSet(a) == findSet(b)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}//연산 횟수 for문 
		
		System.out.println(sb);
	}//Main
}//Class