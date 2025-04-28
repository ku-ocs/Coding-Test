import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M, cnt;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        T = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < T; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(stz.nextToken());
            M = Integer.parseInt(stz.nextToken());
            cnt = 0;

            A = new int[N];
            B = new int[M];

            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(stz.nextToken());
            }

            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(stz.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            count:
            for (int j : A) {
                for (int k : B) {
                    if (j > k) {
                        cnt++;
                    } else {
                        continue count;
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}