// https://www.acmicpc.net/problem/1931
// 회의실 배정

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meetings);
		
		int countRoom=1;
		int stdTime=meetings[0].finish;
		
		
		for (int i = 1; i < N; i++) {
			if (meetings[i].start >= stdTime) {
				countRoom++;
				stdTime=meetings[i].finish;
			}
		}
		
		System.out.println(countRoom);
		
	}//Main
}//Class

class Meeting implements Comparable<Meeting>{
	int start;
	int finish;
	
	public Meeting(int start, int finish){
		super();
		this.start = start;
		this.finish = finish;
	}
	
	@Override
	public int compareTo(Meeting o) {
		int rst = this.finish - o.finish;
		if (rst != 0) return rst;
		else return this.start - o.start;
	}
}