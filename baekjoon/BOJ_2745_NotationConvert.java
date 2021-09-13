import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745_NotationConvert {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int sSize = s.length()-1;
        int ans = 0; int num = 0;
        for (int i = sSize, j=0; i >= 0; i--, j++) {
            char c = s.charAt(i);
            if ('A'<=c && c<='Z') {
                num = c-'A'+10;
            } else {
                num = c-'0';
            }
            ans += num * Math.pow(n,j);
        }
        System.out.println(ans);
    }//Main
}//Class
