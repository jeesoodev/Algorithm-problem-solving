import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16968_LicensePlate1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int result = 1;
		
		char c = s.charAt(0);
		if (c == 'c') result *= 26;
		else result *= 10;
		
		for (int i = 1, size=s.length(); i < size; i++) {
			char curChar = s.charAt(i);
			if (c == curChar) {
				if (curChar == 'c') result *= 25;
				else result *= 9;
			}
			else {
				if (curChar == 'c') result *= 26;
				else result *= 10;
			}
			c = curChar;
		}
		System.out.println(result);
	}
}