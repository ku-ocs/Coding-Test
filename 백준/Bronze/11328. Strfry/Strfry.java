import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer str;

        for(int i = 1; i <= num; i++) {
            str = new StringTokenizer(br.readLine(), " ");
            String s1 = str.nextToken();
            String s2 = str.nextToken();

            if (s1.equals(s2)) {
                bw.write("Possible");
                if (i != num) {
                    bw.write(" \n");
                }
                continue;
            }

            if(s1.length() != s2.length()) {
                bw.write("Impossible");
                if (i != num) {
                    bw.write(" \n");
                }
                continue;
            }

            String[] sArr1 = s1.split("");
            String[] sArr2 = s2.split("");

            String answer = "";

            for(int j = 0; j < sArr2.length; j++) {
                for(int k = 0; k < sArr1.length; k++) {
                    if(sArr2[j].equals(sArr1[k])) {
                        sArr1[k] = "";
                        break;
                    }
                }
            }

            for(String s : sArr1) {
                answer += s;
            }

            if(answer.isEmpty()) {
                bw.write("Possible");
            } else {
                bw.write("Impossible");
            }

            if (i != num) {
                bw.write(" \n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}