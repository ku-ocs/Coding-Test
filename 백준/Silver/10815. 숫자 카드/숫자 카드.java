import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(stz.nextToken());

            int s = 0;
            int e = N;
            while (s < e) {
                int m = (s+e) / 2;
                if (arr[m] >= target) e = m;
                else s = m+1;
            }
            
            if (s >= N || arr[s] != target) {
                bw.write(0 + " ");
            } else {
                bw.write(1 + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}