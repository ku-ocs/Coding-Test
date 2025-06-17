import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, max;
    static long answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        L = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int s = 1;
        int e = (L/M) + 1;
        while (s <= e) {
            int m = (s+e) / 2;
            int cnt = 0;

            // 0~arr[N-1] 사이 휴게소 개수
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    cnt += (arr[0] - 1) / m;
                } else {
                    cnt += (arr[i] - arr[i-1] - 1) / m;
                }
            }

            // L~arr[N-1] 사이 휴게소 개수
            if (N > 0) {
                cnt += (L-arr[N-1]-1) / m;
            }

            // 만약 N이 0 이라면 처음부터 끝까지 휴게소 개수
            if (N == 0) {
                cnt = (L-1)/m;
            }

            if (cnt > M) {
                s = m+1;
            } else {
                e = m-1;
            }
        }

        return s;
    }
}
