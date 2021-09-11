import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10809_FindingAlphabet {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sSize = s.length();

        int[] alphabetArr = new int[26];
        int arrSize = alphabetArr.length;
        for (int i = 0; i < arrSize; i++) {
            alphabetArr[i] = -1;
        }// -1로 초기화

        for (int i = 0; i < sSize; i++) {
            int cur = s.charAt(i)- 'a';
            if (alphabetArr[cur] == -1){ // 아직 해당 알파벳이 안나왔다는 뜻
                alphabetArr[cur] = i;
            }
        }

        for (int i = 0; i < arrSize; i++) {
            sb.append(alphabetArr[i]).append(" ");
        }
        System.out.println(sb);
    }//Main
}//Class
