import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static Set<Integer> twoSumSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSumSet.add(arr[i] + arr[j]);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (twoSumSet.contains(target)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}