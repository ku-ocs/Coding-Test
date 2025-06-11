import java.io.*;
import java.util.*;

public class Main {
    static int N, n1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        n1 = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < N-1; i++) {
            int num = Integer.parseInt(stz.nextToken());
            int gcd = gcd(n1, num);
            bw.write((n1/gcd) + "/" + (num/gcd) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        else return gcd(num2, num1 % num2);
    }
}
