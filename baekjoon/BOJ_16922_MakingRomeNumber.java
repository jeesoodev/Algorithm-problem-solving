import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] input = {1, 5, 10, 50};
	static final int SIZE = 1001;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[SIZE];
		comb(0, 0, 0);
		int result=0;
		for (int i = 0; i < SIZE; i++) {
			if (check[i]) result++;
		}
		System.out.println(result);
	}
	static void comb(int cnt, int start, int sum) {
		if (cnt==N) {
			check[sum]=true; 
			return;
		}
		for (int i = start; i < 4; i++) {
			comb(cnt+1, i, sum+input[i]);
		}
	}//comb
}//Class