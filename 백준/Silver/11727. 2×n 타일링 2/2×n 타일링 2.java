import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        D = new int[N+1];

        if (N >= 1) {
            D[1] = 1;
        }

        if (N >= 2) {
            D[2] = 3;
        }

        for (int i = 3; i <= N; i++) {
            D[i] = (D[i-1]+D[i-2]*2) % 10007;
        }

        System.out.println(D[N]);

        br.close();
    }
}