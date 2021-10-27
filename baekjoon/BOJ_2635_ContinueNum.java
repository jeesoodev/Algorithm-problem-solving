import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Integer> list;
	public static int max;
	public static int cnt;
	public static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int size;
		
		for (int i = 0; i <= N; i++) {
			list = new ArrayList<>();
			getList(i);
			size=list.size();
			
			if (max<size) {
				sb.setLength(0);
				max=size;
				sb.append(size).append("\n");
				for (int j = 0; j < size; j++) {
					sb.append(list.get(j)).append(" ");
				}
			}
		}
		
		System.out.println(sb);
		
	}//Main
	
	public static void getList(int n) {
		list.add(N);
		list.add(n);
		
		int index=0;
		int nextN=0;
		while(true) {
			nextN= (list.get(index)-list.get(index+1));
			if (nextN<0) break;
			list.add(nextN);
			index+=1;
		}
	}
}//Class
