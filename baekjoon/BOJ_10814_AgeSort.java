//https://www.acmicpc.net/problem/10814
//나이순 정렬

import java.io.*;
import java.util.*;

public class BOJ_10814_AgeSort{
	
	static class Member {
		int age;
		int index;
		String name;
		
		public Member(int age, int index, String name) {
			this.age = age;
			this.index = index;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Member[] arr = new Member[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int age = Integer.parseInt(st.nextToken());
        	String name = st.nextToken();
        	arr[i] = new Member(age, i, name);
        }
        
        Arrays.sort(arr, new Comparator<Member>() {
        	@Override
        	public int compare(Member m1, Member m2) {
        		if(m1.age == m2.age) {
        			return m1.index-m2.index;
        		}
        		return m1.age - m2.age;
        	}
        });
        
        for(int i=0; i<N; i++) {
        	sb.append(arr[i].age).append(" ").append(arr[i].name).append("\n");
        }
        System.out.println(sb);
	}//Main

}//Class