//https://www.acmicpc.net/problem/11650
//좌표 정렬하기

import java.io.*;
import java.util.*;

public class BOJ_11650_CoordinateSort{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] arr1, int[] arr2) {
        		if(arr1[0] == arr2[0]) {
        			return arr1[1]-arr2[1];
        		}
        		return arr1[0] - arr2[0];
        	}
        });
        
        for(int i=0; i<N; i++) {
        	sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
	}//Main

}//Class