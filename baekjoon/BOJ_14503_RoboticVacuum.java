import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_RoboticVacuum {

    private static int[][] map;
    private static int ans;
    private static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); // 세로 크기(행)
        int M = Integer.parseInt(st.nextToken()); // 가로 크기(열)

        st = new StringTokenizer(br.readLine()," ");
        int r = Integer.parseInt(st.nextToken()); // 현재 행 좌표
        int c = Integer.parseInt(st.nextToken()); // 현재 열 좌표
        int d = Integer.parseInt(st.nextToken()); // 현재 방향

        // 반시계 방향으로 순서 통일
        if (d==1) d=3; // 문제: 동 -> 서로 변경
        else if(d==3) d=1; // 문제: 서 -> 동으로 변경

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 값 입력 받기

        clean(r, c, d, 1);
        System.out.println(ans);

    }//Main

    static int[] dirR = {-1,0,1,0};
    static int[] dirC = {0,-1,0,1};

    private static void clean(int r, int c, int d, int cnt) {

        if (cnt == 5) moveback(r, c, d%4); // 네 방향 모두 확인했음에도 청소할 곳이 없는 경우 후진
        if (cnt == 9) flag = true;
        if(flag) return;

        if (map[r][c] == 0) {
            ans++; // 한 칸 청소
            map[r][c] = 2; // 청소한 곳 표시
        }


        int curR = r + dirR[(d+1)%4];
        int curC = c + dirC[(d+1)%4];
        if (map[curR][curC] == 0) clean(curR, curC, (d+1)%4, 1);
        else clean(r, c, (d+1)%4, cnt+1);

    }

    private static void moveback(int r, int c, int d) {
        if (d==0) {
            if (map[r+1][c] != 1) clean(r+1, c, d, 1);
            else clean(r+1, c, d, 9);
        }
        else if (d==1){
            if (map[r][c+1] != 1) clean(r, c+1, d, 1);
            else clean(r, c+1, d, 9);
        }
        else if (d==2){
            if (map[r-1][c] != 1) clean(r-1, c, d, 1);
            else clean(r-1, c, d, 9);
        }
        else if (d==3){
            if (map[r][c-1] != 1) clean(r, c-1, d, 1);
            else clean(r, c-1, d, 9);
        }
    }

}//Class
