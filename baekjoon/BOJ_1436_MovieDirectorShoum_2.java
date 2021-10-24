//https://www.acmicpc.net/problem/1436

import java.io.*;

public class BOJ_1436_MovieDirectorShoum_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = 0;
        int num = 665;
        while(index < N){
            num++;
            String s = String.valueOf(num);
            if (s.contains("666")){
                index++;
            }
        }
        System.out.println(num);
    }//Main
}//Class

