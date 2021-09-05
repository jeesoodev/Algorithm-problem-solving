import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_Tomato {

    private static int N, M;
    private static int[][] container;
//    private static boolean[][] visited; // bfs라 일단 만들어놨지만, 토마토가 익으면 0을 1로 바꿨기 때문에, visited 배열 필요 없이 0으로만 체크해도 됐음
    private static int day;
    private static Queue<Point> queue;

    static class Point {
        int y; // 행
        int x; // 열

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        container = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                container[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 토마토 입력 받기

        queue = new ArrayDeque<Point>();
//        visited = new boolean[N][M];

        // 1. 안익은 토마토가 없는지 확인: 없으면 0 출력
        // 2. 익은 토마토 위치 queue에 넣어주기
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curNum = container[i][j];
                if (!flag) {
                    if (curNum == 0) flag = true;
                    else if (curNum == 1) {
//                        visited[i][j] = true;
                        queue.add(new Point(i, j));
                    }
                } else if (curNum == 1) {
//                        visited[i][j] = true;
                        queue.add(new Point(i, j));
                }
            }
        }
        if (!flag) {
            System.out.println(0); return;
        }

        bfs(); // 토마토 익게 하기

        flag = false; // 여기에서 다시 false로 초기화 안해줘서 falg가 항상 true로 나왔었음.
        // 안익은 토마토가 있는지 확인: 있으면 -1 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (container[i][j] == 0) flag = true;
            }
        }

        if (flag) System.out.println(-1);
        else System.out.println(day-1); // 마지막 턴이 돌고 나서 자동적으로 day가 1 증가하므로 -1 해줘야 함
    }//Main

    private static int[] dirY = {-1, 0, 1, 0};
    private static int[] dirX = {0, -1, 0, 1};

    private static void bfs() {

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize-- > 0) {
                Point point = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int ny = point.y + dirY[dir];
                    int nx = point.x + dirX[dir];

//                    if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && container[ny][nx] == 0) {
                    if (0 <= ny && ny < N && 0 <= nx && nx < M && container[ny][nx] == 0) {
//                        visited[ny][nx] = true;
                        container[ny][nx] = 1; // 토마토가 익음
                        queue.add(new Point(ny, nx)); // 익은 토마토 queue에 넣어주기
                    }
                }
            }// queue 한 턴 돌기
            day++;
        }//queue가 빌 때까지 반복
    }//bfs

}//Class