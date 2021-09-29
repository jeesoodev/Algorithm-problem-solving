import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_SnowWhite {

	static int[] nums = new int[9];
	static int[] res = new int[7];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		for (int res : res) {
			System.out.println(res);
		}
	}
	
	static boolean isFinish;
	
	public static void comb(int cnt, int start) {
		int sum=0;
		if (cnt==7) {
			for (int i : res) {
				sum+=i;
			}
			if (sum==100) {
				isFinish=true;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			res[cnt]=nums[i];
			comb(cnt+1, i+1);
			if (isFinish) {
				return;
			}
		}
	}
}
