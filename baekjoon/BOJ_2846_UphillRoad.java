import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846_UphillRoad{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxDiff = 0;
		
		int start = arr[0];
//		int prev = start; // prev를 굳이 쓰지 않아도 됨. 순서만 잘 바꾸면 last 변수 하나만 있어도 됨
		int last = arr[0];
		int pointer;
		
		for (int i = 1; i < N; i++) {
			pointer = arr[i];
			if (last < pointer) {
				last = pointer;
			}	
			else {
				maxDiff = Math.max(maxDiff, (last-start));
				last = pointer;
				start = pointer;
			}
		}
		
		maxDiff = Math.max(maxDiff, (last-start));
		System.out.println(maxDiff);
	}//Main
}//Class