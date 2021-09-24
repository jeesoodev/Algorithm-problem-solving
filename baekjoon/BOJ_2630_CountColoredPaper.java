import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountColoredPaper_2630{
	
	static int[][] arr;
	static int white;
	static int blue;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c]=s.charAt(c*2)-'0';
			}
		}
		
		colorCNT(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
		
	}//Main
	
	static boolean isSame(int y, int x, int length) {
		
		int standard = arr[y][x];
		for (int i = y, nl1 = y+length; i < nl1; i++) {
			for (int j = x, nl2 = x+length; j < nl2; j++) {
				if (arr[i][j]!=standard) {
					return false;
				}
			}
		}
		if (standard==0) white++;
		else blue++;
		return true;
	}
	
	static void colorCNT(int y, int x, int l) {
		if (!isSame(y, x, l)) {
			colorCNT(y, x, l/2);
			colorCNT(y, x+l/2, l/2);
			colorCNT(y+l/2, x, l/2);
			colorCNT(y+l/2, x+l/2, l/2);
		}
	}
	

}//Class