import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = s.charAt(i*2)-'0';
		}
		
		int upLength=1;	int maxUpLength=1;
		
		for (int i = 0, size=N-1; i < size ; i++) {
			if (arr[i] > arr[i+1]) {
				upLength=1;
				continue;
			}
			upLength++;
			maxUpLength = maxUpLength < upLength? upLength:maxUpLength;
		}
		
		int downLength=1; int maxDownLength=1;
		
		for (int i = 0, size=N-1; i < size ; i++) {
			if (arr[i] < arr[i+1]) {
				downLength=1;
				continue;
			}
			downLength++;
			maxDownLength = maxDownLength < downLength? downLength:maxDownLength;
		}
		
		int fLength = maxUpLength > maxDownLength? maxUpLength:maxDownLength;
		System.out.println(fLength);
	}//Main
}//Class