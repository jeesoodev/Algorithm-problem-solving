import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        int weightSum =0;
        int truckNum = truck_weights.length;
        int cnt=truckNum;

        int index = 0;
        for(int i=0; i<bridge_length; i++){
            queue.add(0);
        }
        while(cnt > 0){
            int curWeight = queue.poll();
            if(curWeight != 0) { 
                weightSum -= curWeight;
                cnt--;
            }
            
            if((queue.size() < bridge_length) && (truck_weights[index] <= weight-weightSum)) {
                int curTruck = truck_weights[index];
                // System.out.println(curTruck);
                queue.offer(curTruck); // 큐에 트럭 넣기
                weightSum += curTruck;
                if(index+1 < truckNum){
                    index++; // 다음 트럭 가리키게
                }
            } else {
                queue.offer(0);
            }         
            time++;         
        }
        return time;
    }
}