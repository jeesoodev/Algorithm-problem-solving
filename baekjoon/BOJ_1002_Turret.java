import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testcase = 0; testcase < T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int width = Math.abs(x1-x2);
			int height = Math.abs(y1-y2);
			double distance = Math.sqrt(width*width+height*height);
			
			int longR = r1<r2? r2:r1;
			int shortR = r1>r2? r2:r1;
			
			// 원이 일치 -> -1
			if(x1==x2 && y1==y2 && r1==r2){
				sb.append(-1).append("\n");
			}
			// 중점은 같으나 반지름이 다른 경우 -> 0
			else if (x1==x2 && y1==y2 && r1!=r2) {
				sb.append(0).append("\n");
			}
			// 원 안의 원으로 겹치지 않음 -> 0
			else if(width*width+height*height< (r1-r2)*(r1-r2)) {
				sb.append(0).append("\n");
			}
			// 원이 겹치지 않음 -> 0
			else if ((r1+r2) < distance) {
				sb.append(0).append("\n");
			}
			// 원이 한 점에서 만남 -> 1   ★외접 말고 내접도 있음!!!
			else if ((r1+r2) == distance || distance == (longR-shortR)) {
				sb.append(1).append("\n");
			}
			// 원이 두 점에서 만남 -> 2
			else if ((r1+r2) > distance) {
				sb.append(2).append("\n");
			}
			
		}//TC
		
		System.out.println(sb);
	}//Main
}//Class