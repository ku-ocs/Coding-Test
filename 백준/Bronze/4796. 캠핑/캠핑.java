import java.io.*;
import java.util.*;

public class Main {
    static int L, P, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;
        int tCase = 1;

        while (true) {
            stz = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(stz.nextToken());
            P = Integer.parseInt(stz.nextToken());
            V = Integer.parseInt(stz.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int a = V / P * L;
            int b = Math.min(V % P, L); // b 의 최대값은 L
            int total = a + b;
            bw.write("Case " + tCase + ": " + total + "\n");
            tCase++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
