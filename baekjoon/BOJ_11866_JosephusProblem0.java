import java.io.*;
import java.util.*;

public class BOJ_11866_JosephusProblem0 {
	public static void main(String args[]) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        
        int curNum=0;
        int cnt = 1;
        
        sb.append("<");
        while(!queue.isEmpty()){
            curNum = queue.poll();
            if(cnt%K==0){
            	sb.append(curNum).append(",").append(" ");
            } else{
            	queue.add(curNum);
            }
            cnt++;
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
        
    }//Main
}//Class