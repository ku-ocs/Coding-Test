import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
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

        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isGood(int idx) {
        int s = 0;
        int e = arr.length-1;

        while (true) {
            if (s == idx) {
                s++;
            }

            if (e == idx) {
                e--;
            }

            if (s >= e) {
                return false;
            }

            int target = arr[idx];
            int sum = arr[s] + arr[e];

            if (target == sum) {
                return true;
            } else {
                if (sum > target) {
                    e--;
                } else {
                    s++;
                }
            }
        }
    }
}