//https://www.acmicpc.net/problem/1181
//단어 정렬

import java.io.*;
import java.util.*;

public class BOJ_1181_WordSort{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<N; i++) {
        	String s = br.readLine();
        	if(set.contains(s)) continue;
        	set.add(s);
        	list.add(s);
        }
        
        Collections.sort(list, new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		int l1 = s1.length();
        		int l2 = s2.length();
        		if(l1 == l2) {
        			return s1.compareTo(s2);
        		}
        		return l1-l2;
        	}
        });
        
        for(int i=0, size=list.size(); i<size; i++) {
        	sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
	}//Main

}//Class