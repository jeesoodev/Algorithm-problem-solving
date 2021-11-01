//https://www.acmicpc.net/problem/1927
//최소 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while(N-- > 0) {
			int cur = Integer.parseInt(br.readLine());
			if(cur == 0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else {
					sb.append(0).append("\n");
				}	
			} else {
				pq.add(cur);
			}
		}
		System.out.println(sb);
		
	}//Main
	
}//Class
