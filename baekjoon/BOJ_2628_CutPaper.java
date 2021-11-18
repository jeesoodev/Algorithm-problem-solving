import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		
		int cnt = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < cnt; k++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken())==0)
				arr[Integer.parseInt(st.nextToken())][0]=1;
			else arr[0][Integer.parseInt(st.nextToken())]=1;
		}
		arr[N][0]=1; arr[0][M]=1;
		
		int maxR=0;
		int maxC=0;
		int sum=1;
		
		for (int i = 1, sizeN=N+1; i < sizeN; i++) {
			if (arr[i][0]==1) {
				if (sum>maxR) maxR=sum;
				sum=1;
			}
			else sum++;
		}
		
		for (int i = 1, sizeM=M+1; i < sizeM; i++) {
			if (arr[0][i]==1) {
				if (sum>maxC) maxC=sum;
				sum=1;
			}
			else sum++;
		}
		
		System.out.println(maxR*maxC);
	}
}
