import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, two;
    static Set<Integer> set = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                set.add(arr[i]+arr[j]);
            }
        }

        two = set.stream().mapToInt(Integer::intValue).toArray();

        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                int target = arr[i] - arr[j];
                int s = 0;
                int e = two.length;
                while (s < e) {
                    int m = (s + e) / 2;
                    if(two[m] >= target) e = m;
                    else s = m+1;
                }

                if (two[s] == target) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}