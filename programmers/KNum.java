//https://programmers.co.kr/learn/courses/30/lessons/42748

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int comSize = commands.length;
        int[] ans = new int[comSize];
        
        for(int i=0; i<comSize; i++){
            int[] newArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(newArr);
            ans[i] = newArr[commands[i][2]-1];
        }

        return ans;
    }//Sol
}//Class