import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157_StudyWords {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char ch = 'a';
		int[] alphabet = new int[26];
		
		for (int i = 0, length = s.length(); i < length; i++) {
			ch = s.charAt(i);
			if ('a'<= ch && ch<='z') {
				alphabet[ch-'a']++;
			}
			else {
				alphabet[ch-'A']++;
			}
		}
		
		int index=0;
		int max=0;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i]>max) {
				max=alphabet[i];
				index=i;
			}
		}
		
		int tmp=0;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i]==max) {
				tmp++;
			}
		}
		
		if (tmp>=2) {
			System.out.println("?");
		}
		
		else{
			System.out.println((char) ('A'+index));
		}
		
	}//Main
}//Class