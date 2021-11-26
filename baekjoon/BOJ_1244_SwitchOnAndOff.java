import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] switchArray = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			switchArray[i]=Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(switchArray)); // 확인용
		
		int sNum = Integer.parseInt(br.readLine());
		
		int[] gender = new int[sNum];
		int[] number = new int[sNum];
		
		for (int i = 0; i < sNum; i++) {
			st = new StringTokenizer(br.readLine());
			gender[i] = Integer.parseInt(st.nextToken());
			number[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(gender));
//		System.out.println(Arrays.toString(number));
//		확인용
		
		for (int i = 0; i < sNum; i++) {
			int currentGender = gender[i];
			int currentNumber = number[i];
			if(currentGender==1) {
				
				for (int j = 1; j <= N; j++) {
					if((j)%currentNumber==0) {
						change(switchArray,j);
					}
				}
			}// 남자인 경우
			//  if [번호-1]!=[번호+1]  해당 번호의 숫자 0->1, 1->0 하고 break;
			//      이면 0->1 , 1->0;
			else if(currentGender==2) {
				int count = 1;
				change(switchArray,currentNumber);
				while(true) {
					int left = currentNumber-count;
					int right = currentNumber+count;
					if((left>0) && (right<=N) && (switchArray[left] != switchArray[right])) {
						break;
					}
					else if((left>0) && (right<=N) && (switchArray[left] == switchArray[right])) {
						change(switchArray,left);
						change(switchArray,right);
						count++;
					}
					else {
						break;
					}
				}
			}// 여자인 경우
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(switchArray[i]+" ");
			if(i%20==0){
				System.out.println();
			}
		}
		
	}
	public static void change(int[] switchArray,int switchNum) {
		if(switchArray[switchNum]==0) {
			switchArray[switchNum] = 1;
		}
		else {
			switchArray[switchNum] = 0;
		}
	}
}