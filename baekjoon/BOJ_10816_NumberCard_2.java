import java.util.*;
import java.io.*;

public class BOJ_10816_NumberCard_2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수

        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
            if (map.containsKey(target)){
                sb.append(map.get(target));
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }//Main

}//Class
