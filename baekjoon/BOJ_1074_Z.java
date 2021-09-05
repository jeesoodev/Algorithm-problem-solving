import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class BOJ_1074_Z {
    private static int n, r, c, ans, std;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(ans);
    }//Main

    private static void solve() {
        while (n>0){
            std =  (int) (pow(2, (n - 1)));
            int location = checkLoc();
            ans += std * std * location;
            n--;
        }
    }

    // 4분할 중 어느 위치에 있는지 체크(z 순서대로 0, 1, 2, 3)
    private static int checkLoc() {
        int location = 0;
        // 위쪽
        if (r < std && c < std) location = 0; // 왼쪽
        else if ((r < std && c >= std)) { location = 1; c -= std; }// 오른쪽
        // 아래쪽
        else if (r >= std && c < std) { location = 2; r -= std; } // 왼쪽
        else if (r >= std && c >= std){ location = 3; r -= std; c -= std; } // 오른쪽
        return location;
    }

}//Class