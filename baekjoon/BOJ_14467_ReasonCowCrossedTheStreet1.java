import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14467_ReasonCowCrossedTheStreet1 {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[11];
        Arrays.fill(arr, -1);

        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if (arr[num]!=-1){
                if (arr[num]!=loc){
                    arr[num] = loc;
                    ans++;
                }
            } else {
                arr[num] = loc;
            }
        }
        System.out.println(ans);
    }//Main
}//Class
