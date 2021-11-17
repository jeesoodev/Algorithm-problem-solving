import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char arr[][];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        sb = new StringBuilder("");
        for(int y=0; y<N; y++){
            String str = br.readLine();
            for(int x=0; x<N; x++){
                arr[y][x] = str.charAt(x);
            }
        }
        solve(N,0,0);
        System.out.println(sb);
    }
    private static void solve(int n, int y, int x) {
        if(n==1){
            sb.append(arr[y][x]);
            return;
        }

        boolean oneFlag = true;
        boolean zeroFlag = true;

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] == '1') zeroFlag = false; 
                else oneFlag = false;
            }
        }

        if (zeroFlag) {
            sb.append('0');
        } else if (oneFlag) {
            sb.append('1');
        } else {
            sb.append('(');
            solve(n / 2, y, x);
            solve(n / 2, y, x + n / 2);
            solve(n / 2, y + n / 2, x);
            solve(n / 2, y + n / 2, x + n / 2);
            sb.append(')');
        }

        return;
    }
}