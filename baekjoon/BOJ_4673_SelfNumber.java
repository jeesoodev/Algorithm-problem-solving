public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10001];
		
		for (int i = 1; i <= 10000; i++) {
			String s = Integer.toString(i);
			int sum=0;
			sum+=i;
			for (int j = 0; j < s.length(); j++) {
				sum+=s.charAt(j)-'0';
			}
			if (sum>10000) continue;
			arr[sum]=1;
		}
		for (int index = 1; index <= 10000; index++) {
			if (arr[index]==0) {
				System.out.println(index);
			}
		}
	}
}
