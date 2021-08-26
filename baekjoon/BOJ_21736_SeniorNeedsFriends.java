import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21736_SeniorNeedsFriends {

    private static char[][] campus;
    private static boolean[][] visited;
    private static int ans;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        campus = new char[N][M];
        visited = new boolean[N][M];

        char c;
        int curR = 0, curC = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = c = s.charAt(j);
                if (c == 'I'){
                    curR = i; curC = j;
                }
            }
        }//캠퍼스 입력받기

        dfs(curR, curC);
        if (ans == 0){
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }//Main

    private static int[] dirR = {-1,0,1,0};
    private static int[] dirC = {0,-1,0,1};

    private static void dfs(int curR, int curC) {

        visited[curR][curC] = true; // 방문 표시
        if (campus[curR][curC] == 'P') {
            ans++; // 사람 만남
        }

        // 사방탐색
        for (int d = 0; d < 4; d++) {
            int nr = curR + dirR[d];
            int nc = curC + dirC[d];

            if (nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc] && campus[nr][nc]!='X'){
                dfs(nr,nc);
            }
        }
    }//dfs

}//Class
