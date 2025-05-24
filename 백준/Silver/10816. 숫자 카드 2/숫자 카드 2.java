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
        for (int j = 0; j < M; j++) {
            int target = Integer.parseInt(stz.nextToken());
            int cnt = findUpperIdx(N, target) - findLowerIdx(N, target);
            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int findUpperIdx(int l, int target) {
        int s = 0;
        int e = l;
        while (s < e) {
            int m = (s+e) / 2;
            if (arr[m] > target) e = m;
            else s = m+1;
        }
        return s;
    }

    public static int findLowerIdx(int l, int target) {
        int s = 0;
        int e = l;
        while (s < e) {
            int m = (s+e) / 2;
            if (arr[m] >= target) e = m;
            else s = m+1;
        }
        return s;
    }
}