package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Religion_1863 {
	
	static int[] parents;
	
	// 1. Make-Set
	static void make(int n) {
		// 초기 대표값은 -1을 갖도록 함
		for (int i = 1; i <= n ; i++) {
			parents[i]=-1;
		}
		
	}
	
	// 2. Find-Set
	static int findSet(int a) {
		if (parents[a]<0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// 3. Union
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot==bRoot) return false;
		// 편의상 b집합을 a집합 아래로 넣을 것. 원소 a,b가 아닌 대표자 aRoot와 bRoot를 통해 통합을 관리해야 함
		parents[aRoot] += parents[bRoot]; // 값을 더해주고
		parents[bRoot] = aRoot; // a집합의 대표자 아래로 넣음
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 쌍의 개수
		int religionCnt=0;
		
		parents = new int[N+1];
		
		make(N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		for (int i = 1; i <= N; i++) {
			if (parents[i]<0) religionCnt++;
		}
		
		System.out.println(religionCnt);
	}//Main

}//Class