import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static long[] A, B, C, D, AB, CD;
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];
        int size = (int) Math.pow(N, 2);
        AB = new long[size];
        CD = new long[size];

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(stz.nextToken());
            B[i] = Integer.parseInt(stz.nextToken());
            C[i] = Integer.parseInt(stz.nextToken());
            D[i] = Integer.parseInt(stz.nextToken());
        }

        int ABIdx = 0;
        int CDIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[ABIdx++] = A[i] + B[j];
                CD[CDIdx++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int s = 0;
        int e = CD.length-1;

        while (s < AB.length && e >= 0) {
            long sum = AB[s] + CD[e];

            if (sum > 0) {
                e--;
                continue;
            }

            if (sum < 0) {
                s++;
                continue;
            }

            int sCnt = 1;
            while (s < AB.length-1 && AB[s] == AB[s+1]) {
                sCnt++;
                s++;
            }

            int eCnt = 1;
            while (e > 0 && CD[e] == CD[e-1]) {
                eCnt++;
                e--;
            }

            answer += (long) sCnt*eCnt;
            s++;
        }


        System.out.println(answer);
    }
}
