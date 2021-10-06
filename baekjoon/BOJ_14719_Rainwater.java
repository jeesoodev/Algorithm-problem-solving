import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14719_Rainwater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        boolean[][] map = new boolean[H][W];
        for (int c = 0; c < W; c++) {
            int height = Integer.parseInt(st.nextToken());
            for (int r = 0; r < height; r++) {
                map[r][c] = true;
            }
        }// 배열 입력 받기

        int ans = 0;
        for (int r = 0; r < H; r++) {
            int tmp = 0; boolean flag = false;
            for (int c = 0; c < W; c++) {
                if (map[r][c] && !flag) flag = true; // 빗물 모으기 가능
                else if (!map[r][c] && flag) tmp++; // 빗물 카운트
                else if (map[r][c] && flag) { // 다시 벽이 나올 때 카운트되었던 빗물을 ans에 더해줌
                    ans+=tmp; tmp=0;
                }
            }
        }
        System.out.println(ans);
    }//Main
}//Class
