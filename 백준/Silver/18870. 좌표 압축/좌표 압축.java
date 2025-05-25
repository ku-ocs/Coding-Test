import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr, arr2;
    static Set<Long> set = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(stz.nextToken());
            arr[i] = l;
            set.add(l);
        }

        arr2 = set.stream().mapToLong(Long::longValue).toArray();

        for (long l : arr) {
            int s = 0;
            int e = arr2.length;

            while (s < e) {
                int m = (s+e) / 2;
                if (arr2[m] >= l) e = m;
                else s = m+1;
            }

            bw.write(s+ " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}