import java.io.;
import java.util.;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int size = progresses.length; 
        if(size==1) return new int[]{1};

        int[] remains = new int[size]; //남은 작업
        // System.out.println(size);
        for(int i=0; i<size; i++){
            remains[i] = 100-progresses[i];
        }

        List<Integer> list = new ArrayList<>();

        int day;
        if((remains[0]%speeds[0])!=0) {
                day = remains[0]/speeds[0] + 1;
            } else {
                day = remains[0]/speeds[0];
            }

        int cnt=0; int cur=0;
        for(int i=0; i<size; i++){
            if((remains[i]%speeds[i])!=0) {
                cur = remains[i]/speeds[i] + 1;
            } else {
                cur = remains[i]/speeds[i];
            }

            if(day >= cur) { cnt++; }
            else { list.add(cnt); cnt=1; day=cur; }
        }

        list.add(cnt);

        int listSize = list.size();
        int[] answer = new int[listSize];
        for(int i=0; i<listSize; i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}