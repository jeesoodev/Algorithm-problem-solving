import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1110_AddCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(br.readLine());
        int cycle = 0;
        int newNum = firstNum;
        int n1, n2, sum = 0;

        while (true) {
            n1 = newNum/10;
            n2 = newNum%10;
            sum = n1+n2;
            newNum = n2*10 + (sum%10);

            cycle++;
            if (newNum == firstNum) break;
        }
        System.out.println(cycle);
    }//Main
}//Class
