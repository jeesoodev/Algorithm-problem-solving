import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] D = new int[N];
		Arrays.fill(D, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i]>input[j] && D[i]<D[j]+1) {
					D[i] = D[j]+1;
				}
			}
		}
		
		int maxLength=0;
		for (int i = 0; i < N; i++) {
			if (D[i]>maxLength) maxLength=D[i];
		}
		
		System.out.println(maxLength);
	}//Main

}//Class
