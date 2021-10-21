import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_StartAndLink {

	private static int[][] synergyMap;
	static int minDif = Integer.MAX_VALUE;
	static int[] arr1;
	static int[] arr2;
	static boolean[] selected;
	private static int N;
	private static int mN;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 인원 수
		mN = N/2; // 한 팀당 인원 수
		StringTokenizer st = null;
		
		synergyMap = new int[N+1][N+1]; // 시너지 정보
		selected = new boolean[N+1]; // 해당 번호가 선택 되었는지 판단
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= N; j++) {
				synergyMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr1 = new int[mN];
		arr2 = new int[mN];
		comb(0,1);
		
		System.out.println(minDif);
		
	}//Main
	
	static void comb(int cnt, int start) {
		if (cnt==mN) {
			for (int i = 1, index=0; i <= N; i++) {
				if (!selected[i]) {
					arr2[index]=i;
					index++;
				}
			}
			int sum1 = getSynergy(arr1);
			int sum2 = getSynergy(arr2);
			
			int dif = Math.abs(sum1-sum2);
			minDif = Math.min(minDif, dif);
			return;	
		}
		
		
		for (int i = start; i <= N; i++) {
			if (selected[i]) {
				continue;
			}
			arr1[cnt]=i;
			selected[i]=true;
			comb(cnt+1,i+1);
			selected[i]=false;
		}
	}
	
	static int getSynergy(int[] arr) {
		int sum=0;
		
		for (int i = 0; i < mN; i++) {
			for (int j = i+1; j < mN; j++) {
				sum += synergyMap[arr[i]][arr[j]];
				sum += synergyMap[arr[j]][arr[i]];
			}
		}
		return sum;
	}
	

}//Class