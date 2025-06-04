import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long cnt;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        if (arr[0] > 0) {
            System.out.println(0);
            return;
        }

        if (arr[N-1] < 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) break;
            for (int j = i+1; j < N; j++) {
                int sum = arr[i] + arr[j];

                int s = j+1;
                int e = N-1;

                int l = lowerBound(sum, s, e);
                int u = upperBound(sum, s, e);

                cnt += u-l;
            }
        }

        System.out.println(cnt);
    }

    public static int lowerBound(int sum, int s, int e) {
        while (s <= e) {
            int m = (s + e) / 2;
            if (sum + arr[m] >= 0) {
                e = m-1;
            } else {
                s = m+1;
            }
        }
        return s;
    }

    public static int upperBound(int sum, int s, int e) {
        while (s <= e) {
            int m = (s + e) / 2;
            if (sum + arr[m] > 0) {
                e = m-1;
            } else {
                s = m+1;
            }
        }

        return s;
    }

}