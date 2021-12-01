// https://programmers.co.kr/learn/courses/30/lessons/12985
// 예상 대진표

class Solution{
    public int solution(int n, int a, int b) {
        int ans = 0;
        int N = n/2;
        int stt1 = 1;
        int stt2;
        
        while(true){
            stt2 = stt1 + N;
            if(a<stt2 && b<stt2){
                N = N/2;
            } else if(a>=stt2 && b>=stt2){
                N = N/2;
                stt1 = stt2;
            } else {
                ans = calculate(N);
                break;
            }
        }

        return ans;
    }//Sol
    
    int calculate(int N){
        int round = 0;
        while(N>1){
            N = N/2;
            round ++;
        }
        
        return round+1; 
    }
    
}//Class