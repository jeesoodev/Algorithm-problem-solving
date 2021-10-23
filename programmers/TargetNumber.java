import java.io.*;
import java.util.*;

class Solution {
    
    int ans = 0;
    int arrSize;
    int targetNum;
    int[] numArr;
    
    public int solution(int[] numbers, int target) {

        arrSize = numbers.length;
        targetNum = target;
        numArr = numbers;

        dfs(0, 0);     
        return ans;
    }
    
    public void dfs(int sum, int index){
        if(index == arrSize){
            if(sum == targetNum) ans++; return;
        }
        dfs(sum+numArr[index], index+1);
        dfs(sum-numArr[index], index+1);
    }
}