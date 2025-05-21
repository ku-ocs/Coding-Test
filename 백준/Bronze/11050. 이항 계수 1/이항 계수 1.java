import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int num1 = 1;
        int num2 = 1;

        for (int i = 0; i < k; i++) {
            num1 *= (n-i);
            num2 *= (i+1);
        }

        System.out.println(num1/num2);

        br.close();
    }
}