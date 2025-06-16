import java.io.*;
import java.util.Arrays;
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

        for (int i = 0; i < AB.length; i++) {
            long num = AB[i];
            isFind = false;
            int l = lowerBound(-num);
            int u = upperBound(-num);

            if (isFind) {
                answer += u-l;
            }
        }

        System.out.println(answer);
    }

    public static int lowerBound(long num) {
        int s = 0;
        int e = CD.length-1;
        while (s <= e) {
            int m = (s+e) / 2;
            if (CD[m] >= num) e = m-1;
            else s = m+1;
        }
        if (s < CD.length && CD[s] == num) isFind = true;
        return s;
    }

    public static int upperBound(long num) {
        int s = 0;
        int e = CD.length-1;
        while (s <= e) {
            int m = (s+e) / 2;
            if (CD[m] > num) e = m-1;
            else s = m+1;
        }
        return s;
    }
}
