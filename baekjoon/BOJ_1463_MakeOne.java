import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463_MakeOne {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		if (N==1) {
			arr[1]=0;
		}
		else if (N==2) {
			arr[2] = 1;
		}
		else {
			arr[2] = arr[3] = 1;
		}
		for (int i = 4; i <= N; i++) {
			int minVal = Integer.MAX_VALUE;
			int temp=0;
			if (i%3==0) {
				temp = i/3;
				minVal = Math.min(minVal, arr[temp]);
			}
			if (i%2==0) {
				temp = i/2;
				minVal = Math.min(minVal, arr[temp]);
			}
			temp = i-1;
			minVal = Math.min(minVal, arr[temp]);
			
			arr[i] = minVal+1;
		}
		
		System.out.println(arr[N]);
	}
}