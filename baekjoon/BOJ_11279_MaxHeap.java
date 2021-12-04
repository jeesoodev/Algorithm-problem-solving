// https://www.acmicpc.net/problem/11279
// 최대 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int curNum;
		for (int i = 0; i < N; i++) {
			curNum = Integer.parseInt(br.readLine());
			if (curNum == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
			else {
				pq.offer(curNum);
			}
		}
		System.out.println(sb);
	}//Main
}//Class