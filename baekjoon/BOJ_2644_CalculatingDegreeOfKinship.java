import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
1. 친척 관계에 있다 == 두 숫자가 연결되어 있다.
2. 한 숫자에서 다른 숫자로 한 번 이동할 때마다 촌수 +1씩 증가한다.
3. 최단 연결 길이가 촌수가 된다. => bfs 사용
*/

public class BOJ_2644_CalculatingDegreeOfKinship {
    private static int N;
    private static boolean[][] linkArr;
    private static boolean[] visited;
    private static int from, to;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); // 관계 개수

        linkArr = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int parents = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            linkArr[parents][child] = linkArr[child][parents] = true;
        }// 촌수 관계 그래프 입력 받기

        boolean flag = bfs();
        if (!flag) ans = -1;
        System.out.println(ans);
    }//Main

    private static boolean bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[from] = true;
        queue.add(from);

        while(!queue.isEmpty()){
            int qSize = queue.size();

            while(qSize-- > 0) {
                int curNum = queue.poll();
                if (curNum == to) {
                    return true;
                }
                for (int i = 1; i <= N; i++) {
                    if (linkArr[curNum][i] && !visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
            ans++;
        }//queue에 값이 있는 동안 반복
        return false;
    }//Bfs

}//Class
