import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_SugarDelivery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int minNum=-1;
		int numFive = N/5;
		int numThree=0;
		int remainder = N%5;
		
		if (remainder%3==0) {
			numThree = remainder/3;
			minNum = numFive+numThree;
		}
		else {
			while(numFive>0) {
				numFive--;
				remainder = N-(numFive*5);
				if (remainder%3==0) {
					numThree = remainder/3;
					minNum = numFive+numThree;
					break;
				}
			}
		}
		System.out.println(minNum);
	}//Main
}//Class