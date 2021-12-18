// https://www.acmicpc.net/problem/1922
// 네트워크 연결

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
	
	static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) { // 매개변수가 어느 집합에 속해있는지 대표자를 찾아줌
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		
		int M = Integer.parseInt(br.readLine());
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(from,to,weight));
		}
		
		make();
		
		int count=0;
		int resultSum=0;
		
		for (int i = 0; i < M; i++) {
			Edge e = pq.poll();
			if (union(e.from, e.to)) {
				count++;
				resultSum += e.weight;
				if (count==N-1) break;
			}
		}
		
		System.out.println(resultSum);
		
	}//Main
}//Class