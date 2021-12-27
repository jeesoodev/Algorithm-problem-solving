import java.io.*;
import java.util.*;

public class Main {
	
	static class MyMap implements Comparable<MyMap>{
		long key; long value;
		public MyMap(long key, long value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public int compareTo(MyMap o) {
//			if(this.value == o.value) {
//				// key 기준: 오름차순
//				return (int) (this.key-o.key);
//			}
//			return (int) -(this.value-o.value); // value 기준: 내림차순
			if(this.value > o.value){
			    return -1;
			}
			else if(this.value < o.value){
			    return 1;
			}
			else{
			    if(this.key > o.key){
			        return 1;
			    }
			    else{
			        return -1;
			    }
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Map<Long, Long> map = new HashMap<Long, Long>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            long curNum = Long.parseLong(br.readLine());
            if(map.containsKey(curNum)){
            	map.put(curNum, map.get(curNum)+1);
            } else {
            	map.put(curNum, (long) 1);
            }
        }
        
        List<MyMap> list = new ArrayList<>();
        
        Iterator<Long> keys = map.keySet().iterator();
        while(keys.hasNext()) {
        	long key = keys.next();
        	long value = map.get(key);
        	list.add(new MyMap(key, value));
        }
        
        // value 기준: 내림차순, key 기준: 오름차순 정렬
        // Collections.sort()
        Collections.sort(list);
        System.out.println(list.get(0).key);
        
	}//Main
}//Class