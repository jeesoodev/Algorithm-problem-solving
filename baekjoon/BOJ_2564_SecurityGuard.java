import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][2];
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken()); // 동근이가 있는 방향
		int point = Integer.parseInt(st.nextToken()); // 위치
		
		int minSum=0; // 최단거리 합
		int left=0;
		int right=0;
		
		for (int i = 0; i < num; i++) {
			if (dir==1) {
				if (arr[i][0]==1) {
					int tmp = arr[i][1]-point;
					minSum += (tmp>0? tmp:-tmp); 
				}
				else if (arr[i][0]==3) {
					minSum += (point + arr[i][1]);
				}
				else if (arr[i][0]==4) {
					minSum += (M-point + arr[i][1]);
				}
				else if (arr[i][0]==2) {
					left = point+arr[i][1]+N;
					right = M-point+M-arr[i][1]+N;
					minSum += Math.min(left, right);
				}
			}
			else if (dir==2) {
				if (arr[i][0]==2) {
					int tmp = arr[i][1]-point;
					minSum += (tmp>0? tmp:-tmp); 
				}
				else if (arr[i][0]==3) {
					minSum += (point + N-arr[i][1]);
				}
				else if (arr[i][0]==4) {
					minSum += (M-point + N-arr[i][1]);
				}
				else {
					left = point+arr[i][1]+N;
					right = M-point+M-arr[i][1]+N;
					minSum += Math.min(left, right);
				}
			}
			else if (dir==3) {
				if (arr[i][0]==3) {
					int tmp = arr[i][1]-point;
					minSum += (tmp>0? tmp:-tmp); 
				}
				else if (arr[i][0]==1) {
					minSum += (point + arr[i][1]);
				}
				else if (arr[i][0]==2) {
					minSum += (N-point + arr[i][1]);
				}
				else {
					left = point+arr[i][1]+M;
					right = N-point+N-arr[i][1]+M;
					minSum += Math.min(left, right);
				}
			}
			else if (dir==4) {
				if (arr[i][0]==4) {
					int tmp = arr[i][1]-point;
					minSum += (tmp>0? tmp:-tmp); 
				}
				else if (arr[i][0]==1) {
					minSum += (point + M-arr[i][1]);
				}
				else if (arr[i][0]==2) {
					minSum += (N-point + M-arr[i][1]);
				}
				else {
					left = point+arr[i][1]+M;
					right = N-point+N-arr[i][1]+M;
					minSum += Math.min(left, right);
				}
			}
			
		}//상점 개수 for문
		
		System.out.println(minSum);
	}//Main
}//Class
