import java.io.;
import java.util.;

class Solution {
    public int[] solution(int[] answers) {

        int[][] p = new int[][]{
            {1, 2, 3, 4, 5}, 
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[3];

        int size = answers.length;
        for(int i=0; i<size; i++){
            for(int j=0; j<p.length; j++){
                if(answers[i] == p[j][i%(p[j].length)]){
                    score[j]++;
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();

        int maxScore = 0;
        for(int i=0; i<3; i++){
            if(maxScore < score[i]){
                list.clear();
                list.add(i+1);
                maxScore = score[i];
            } else if (maxScore == score[i]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}