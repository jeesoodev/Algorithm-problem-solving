import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int[][] arr;
	public static boolean[][] students;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			arr[i] = new int[k];
			
			for (int j = 0; j < k; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 과목별 수업 시간 2차원 배열에 저장
		
		int M = Integer.parseInt(br.readLine()); // 학생 수
		students = new boolean[M][50+1]; // 학생마다의 시간표 배열
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			
			int temp = 0;
			for (int j = 0; j < p; j++) {
				temp = Integer.parseInt(st.nextToken());
				students[i][temp] = true;
			}
		}// 학생마다 비어 있는 교시를 true로 체크
		
		for (int num = 0; num < M; num++) {
			sb.append(solve(num)).append("\n");
		}// 학생마다 가능한 과목 수 구하기
		
		System.out.println(sb);
	}//Main
	
	public static int solve(int num) {
		int result = 0;
		
		for (int i = 0; i < N; i++) { // 과목 수만큼 반복
			boolean flag = false;
			
			for (int j = 0, size = arr[i].length; j < size; j++) {
				if (!students[num][arr[i][j]]) {
					flag = true;
					break;
				}
			}
			if (flag) continue;
			result++;
		}// 과목마다 들을 수 있는지 검사
		
		return result;
	}//Solve
}//Class