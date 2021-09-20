import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935_StringExplosion2 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String std = br.readLine();
        String part = br.readLine();
        int partSize = part.length();

        for (int i = 0, stdSize=std.length(); i < stdSize; i++) {
            sb.append(std.charAt(i));
            if (sb.length() >= partSize) {
                boolean isSame = true;
                for (int j = 0; j < partSize; j++) {
                    if (sb.charAt(sb.length() - partSize + j) != part.charAt(j)) {
                        isSame = false; break;
                    }
                }
                if(isSame){ sb.setLength(sb.length() - partSize); }
            }
        }
        if (sb.length()>0){
            System.out.println(sb);
        } else {
            System.out.println("FRULA");
        }
    }//Main
}//Class
