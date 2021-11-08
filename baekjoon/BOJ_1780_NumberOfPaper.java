import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_NumberOfPaper {
	
	static int[][] map;
	static int minusC;
	static int zeroC;
	static int plusC;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count(0, 0, N);
		System.out.println(minusC);
		System.out.println(zeroC);
		System.out.println(plusC);
		
	}
	
	static boolean isSame(int y, int x, int l) {
		int std = map[y][x];
		for (int i = y, ly=y+l; i < ly; i++) {
			for (int j = x, lx=x+l; j < lx; j++) {
				if (map[i][j]!=std) return false;
			}
		}
		if (std==-1) minusC++;
		else if (std==0) zeroC++;
		else plusC++;
		return true;
	}
	
	static void count(int y, int x, int l) {
		int nl = l/3;
		if (!isSame(y, x, l)) {
			count(y,x,nl); 
			count(y,x+nl,nl); 
			count(y,x+nl*2,nl); 
			count(y+nl,x,nl); 
			count(y+nl,x+nl,nl); 
			count(y+nl,x+nl*2,nl); 
			count(y+nl*2,x,nl); 
			count(y+nl*2,x+nl,nl); 
			count(y+nl*2,x+nl*2,nl); 
		}
	}
	
}//Class