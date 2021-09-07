import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_SnakeAndGhostLeg {

    private static int[] board;
    private static int cnt;
    private static Queue<Integer> queue;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        board = new int[101]; // 게임판
        visited = new boolean[101]; // 게임판

        for (int i = 0; i < 101; i++) {
            board[i] = i;
        }// 게임판에 숫자 넣기

        for (int i = 0, size=N+M; i < size; i++) {
            st = new StringTokenizer(br.readLine()," ");
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }// 사다리와 뱀 적용

        queue = new ArrayDeque<Integer>();
        queue.add(1);
        bfs();

        System.out.println(cnt);
    }//Main

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0){
                int num = queue.poll();
                visited[num] = true;
                if (board[num] == 100) return;
                for (int i = 1; i <= 6; i++) {
                    int nextNum = board[num]+i;
                    if (nextNum<101 && !visited[nextNum]) queue.add(nextNum);
                }
            }
            cnt++;
        }
    }//bfs
}//Class
