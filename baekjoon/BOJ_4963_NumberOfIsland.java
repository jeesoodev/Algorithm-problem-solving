import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_NumberOfIsland {

    private static int[][] square;
    private static boolean[][] visited;
    private static int w, h;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken()); //열
            h = Integer.parseInt(st.nextToken()); //행

            if (w == 0 && h == 0) break;
            square = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }// 정사각형 입력 받기

            visited = new boolean[h][w];
            int islandCnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (square[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true; // 방문처리
                        dfs(i, j);
                        islandCnt++;
                    }
                }
            }
            sb.append(islandCnt).append("\n");
        }
        System.out.println(sb);
    }//Main

    private static int[] dirR = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dirC = {0, 1, 1, 1, 0, -1, -1, -1};

    private static void dfs(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + dirR[d];
            int nc = c + dirC[d];
            if (0 <= nr && nr < h && 0 <= nc && nc < w && square[nr][nc]==1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }//dfs

}//Class
