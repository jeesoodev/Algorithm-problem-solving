import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		int[] sumArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int tmp=0;
		
		for (int i = 0; i < N; i++) {
			tmp += Integer.parseInt(st.nextToken());
			sumArr[i]= tmp;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int i=0, j=0;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			if (i==1) sb.append(sumArr[j-1]).append("\n");
			else sb.append(sumArr[j-1]-sumArr[i-2]).append("\n");
		}
		
		System.out.println(sb);

	}//Main
}//Class