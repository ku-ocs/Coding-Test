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

        if (arr[N-1] < 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) break;
            int s = i+1;
            int e = N-1;

            while (s < e) {
                int sum = arr[i] + arr[s] + arr[e];
                if (sum > 0) {
                    e--;
                    continue;
                }

                if (sum < 0) {
                    s++;
                    continue;
                }

                int sVal = arr[s];
                int eVal = arr[e];
                if (sVal == eVal) {
                    int count = e-s+1;
                    cnt += count*(count-1)/2;
                    break;
                }

                int sCount = 0;
                int eCount = 0;
                while (s <= e && arr[s] == sVal) {
                    sCount++;
                    s++;
                }

                while (s <= e && arr[e] == eVal) {
                    eCount++;
                    e--;
                }

                cnt += sCount * eCount;
            }
        }

        System.out.println(cnt);
    }
}