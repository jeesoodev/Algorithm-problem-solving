//https://programmers.co.kr/learn/courses/30/lessons/42888

import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int recordSize = record.length;
        
        Map<String, String> map = new HashMap<>(); // 아이디와 닉네임 저장
        List<String[]> list = new ArrayList<>(); // 출력할 리스트  // new LinkedList 했을 때 25번-32번 시간초과 코드

        
        for(int i=0; i<recordSize; i++){
            String s = record[i];
            StringTokenizer st = new StringTokenizer(s);
            
            String inOut = st.nextToken();
            
            if(inOut.equals("Enter")){
                String uid = st.nextToken();
                String nickName = st.nextToken();
                
                String[] arr = new String[2];
                arr[0] = inOut;
                arr[1] = uid;
                map.put(uid, nickName);
                list.add(arr);
                
            } else if(inOut.equals("Change")){
                String uid = st.nextToken();
                String nickName = st.nextToken();
                map.put(uid, nickName);
            } else {
                String uid = st.nextToken();
                String[] arr = new String[2];
                arr[0] = inOut;
                arr[1] = uid;
                list.add(arr);
            }
        }//recordSize 들어온 입력만큼 처리
        
        StringBuilder sb = new StringBuilder();
        int lSize = list.size();
        String[] ans = new String[lSize];
        System.out.println(lSize);
        for(int i=0; i<lSize; i++){
            String[] cur = list.get(i);
            if((cur[0]).equals("Enter")){
                sb.append(map.get(cur[1])).append("님이").append(" 들어왔습니다.");
            } else {
                sb.append(map.get(cur[1])).append("님이").append(" 나갔습니다.");
            }
            ans[i] = sb.toString();
            sb.setLength(0);
        }
                
        return ans;

    }//Sol
}//Class