import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer stz1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stz2 = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        String num = stz2.nextToken();

        while (stz1.hasMoreTokens()) {
            if (stz1.nextToken().equals(num)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}