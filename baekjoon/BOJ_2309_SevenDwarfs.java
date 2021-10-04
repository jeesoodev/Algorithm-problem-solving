import java.io.*;
import java.util.*;

public class BOJ_2309_SevenDwarfs {

    static StringBuilder sb = new StringBuilder();
    static int[] heightsArr = new int[9];
    static int[] selectedArr = new int[7];
    static boolean completed;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            heightsArr[i] = Integer.parseInt(br.readLine());
        }
        comb(0, 0, 0);
        System.out.println(sb);
    }//Main

    static void comb(int start, int cnt, int sum){
        if(cnt==7){
            if(sum==100){
                completed = true;
                Arrays.sort(selectedArr);
                for(int i=0; i<7; i++){
                    sb.append(selectedArr[i]).append("\n");
                }
                completed = true;
            }
            return;
        }
        for(int i=start; i<9; i++){
            if(!completed){
                selectedArr[cnt] = heightsArr[i];
                comb(i+1, cnt+1, sum+heightsArr[i]);
            }
        }

    }//comb
}//Class