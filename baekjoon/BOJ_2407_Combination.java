import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		BigInteger result, tmp;
		
		result = tmp = new BigInteger("1");
		
		if(n!=r){
			
			BigInteger[] arr = new BigInteger[101];
			
			for (int i = 1; i <= 100; i++) {
				tmp = arr[i] = tmp.multiply(new BigInteger(Integer.toString(i)));
			}
			
			result = arr[n].divide(arr[n-r]).divide(arr[r]);
		}
		
		System.out.println(result);
	
	}//Main
}//Class