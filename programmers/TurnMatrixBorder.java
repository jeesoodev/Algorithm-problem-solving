// https://programmers.co.kr/learn/courses/30/lessons/77485
// 행렬 테두리 회전하기

class Solution {
    
    int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {
        int tc = queries.length;
        int[] ans = new int[tc];
        arr = new int[rows][columns];
        
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = num++;
            }
        }
        
        for(int t=0; t<tc; t++){
            int x1 = queries[t][0]-1;
            int y1 = queries[t][1]-1;
            int x2 = queries[t][2]-1;
            int y2 = queries[t][3]-1;
            
            ans[t] = turnArray(x1, y1, x2, y2);
        }//tc만큼 반복
               
        return ans;
    }//Sol
    
    int turnArray(int x1, int y1, int x2, int y2){
        int min = 10000;
        int tmp = arr[x1][y1];
        
        int cur;
        
        // 위로
        for(int r=x1+1; r<=x2 ; r++){
            cur = arr[r-1][y1] = arr[r][y1];
            min = Math.min(min, cur);
        }        
        // 왼쪽으로
        for(int c=y1+1; c<=y2 ; c++){
            cur = arr[x2][c-1] = arr[x2][c];
            min = Math.min(min, cur);
        }
        // 아래로
        for(int r=x2-1; r>=x1 ; r--){
            cur = arr[r+1][y2] = arr[r][y2];
            min = Math.min(min, cur);
        }
        // 오른쪽으로
        for(int c=y2-1; c>y1 ; c--){
            cur = arr[x1][c+1] = arr[x1][c];
            min = Math.min(min, cur);
        }
        
        min = Math.min(min, tmp);
        arr[x1][y1+1] = tmp;
    
        return min;
    }//turnArray
    
    
}//Class