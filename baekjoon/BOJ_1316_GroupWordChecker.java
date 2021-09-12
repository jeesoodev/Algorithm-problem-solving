import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316_GroupWordChecker {

    private static boolean[] checkAlphabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans=0; // 그룹 단어 개수

        String s;
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            checkAlphabet = new boolean[26];

            char prev = s.charAt(0);
            char cur;
            checkAlphabet[(prev-'a')]=true;

            boolean flag = true;
            for (int j = 1, size = s.length(); j < size; j++) {
                cur = s.charAt(j);
                if(checkAlphabet[(cur-'a')] && cur!=prev){
                    flag=false; break;
                } else{
                    checkAlphabet[(cur-'a')]=true;
                }
                prev = cur;
            }// 그룹 단어인지 체크

            if (flag) ans++;
        }//TC
        System.out.println(ans);
    }//Main

}//Class
