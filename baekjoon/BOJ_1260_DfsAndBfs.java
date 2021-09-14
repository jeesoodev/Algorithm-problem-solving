import java.io.*;
import java.util.*;

public class BOJ_1260_DfsAndBfs {

    private static int N, M;
    private static boolean[] visited;
    private static boolean[][] linkInfo;
    private static StringBuilder sb;
    private static Queue<Integer> queue;

    public static void main(String args[]) throws IOException{
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1]; //노드별 방문 여부 체크
        linkInfo = new boolean[N+1][N+1]; //연결 정보

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            linkInfo[n1][n2] = linkInfo[n2][n1] = true; //연결 정보 입력
        }

        visited[startNode] = true;
        sb.append(startNode).append(" ");
        dfs(startNode, 1); //dfs
        sb.append("\n");

        visited = new boolean[N+1]; //bfs용 visited 새로 생성
        queue = new LinkedList<>(); //queue 생성

        bfs(startNode);

        System.out.println(sb);
    }//Main

    private static void dfs(int start, int cnt){
        if(cnt==N) { return;}
        for(int i=1; i<=N; i++){
            if(!visited[i] && linkInfo[start][i]) {
                visited[i]=true;
                sb.append(i).append(" ");
                dfs(i, cnt+1); //다음 노드로 이동
            }//해당 노드를 방문한 적 없고, 연결이 되어 있을 때 이동
        }
    }//dfs

    private static void bfs(int startNode){
        visited[startNode]=true; // 첫 번째 노드 방문 처리
        queue.add(startNode);

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            sb.append(curNode).append(" ");

            for(int i=1; i<=N; i++){
                if(!visited[i] && linkInfo[curNode][i]){
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }//queue가 비지 않을 때까지 반복
    }//bfs
}//Class