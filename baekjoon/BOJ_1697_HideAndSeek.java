import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1697_HideAndSeek {

    private static int start; //수빈이 위치
    private static int goal; //동생 위치
    private static Queue<Integer> queue;
    private static boolean[] visited;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();
        visited = new boolean[200001];

        visited[start] = true;
        queue.add(start);
        bfs();
        System.out.println(ans);
    }//Main

    private static void bfs() {
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int curLoc = queue.poll();
                if (curLoc == goal) return;
                else {
                    int n1 = curLoc-1;
                    if (0<=n1 && !visited[n1]){
                        visited[n1]=true;
                        queue.add(n1);
                    }
                    int n2 = curLoc+1;
                    if (n2<=200000 && !visited[n2]){
                        visited[n2]=true;
                        queue.add(n2);
                    }
                    int n3 = curLoc*2;
                    if (n3<=200000 && !visited[n3]){
                        visited[n3]=true;
                        queue.add(n3);
                    }
                }
            }
            ans++;
        }//queue에 값이 있는 동안 반복
    }//bfs

}//Class
