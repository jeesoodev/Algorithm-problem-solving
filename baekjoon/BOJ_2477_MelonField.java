import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine()); // 1m^2당 참외 개수를 입력 받음
		
		int[] lengthArr = new int[12];
		
		// 시작 꼭지점부터 반시계 방향으로 길이 6개를 받음
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine()); 
			st.nextToken();
			lengthArr[i]=lengthArr[i+6]=Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int sum = 0;
		int index=0;
		
		for (int i = 0; i < 6; i++) {
			sum = lengthArr[i]+lengthArr[i+1];
			if (max<sum) {
				max=sum;
				index = i;
			}
		}
		
		int area = lengthArr[index]*lengthArr[index+1]-lengthArr[index+3]*lengthArr[index+4];
		System.out.println(area*k);
	
	}//Main
}//Class
