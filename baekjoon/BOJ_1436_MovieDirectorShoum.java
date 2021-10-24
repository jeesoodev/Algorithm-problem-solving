//https://www.acmicpc.net/problem/1436

import java.io.*;
import java.util.*;

public class BOJ_1436_MovieDirectorShoum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int num = 666;
        while(index <= 10000){
            String s = String.valueOf(num);
            if (s.contains("666")){
                list.add(num);
                index++;
            }
            num++;
        }
        System.out.println(list.get(N-1));
    }//Main
}//Class
