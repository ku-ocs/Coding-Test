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
            int s = 0;
            int e = arr.length-1;

            if (target == arr[s] || target == arr[e]) {
                bw.write(1 + "\n");
                continue;
            }

            while (true) {
                int mid = (e + s) / 2;
                if (arr[mid] > target) {
                    e = mid;
                } else if (arr[mid] < target) {
                    s = mid;
                } else {
                    bw.write(1 + "\n");
                    break;
                }

                if (target != arr[s] && target != arr[e] && e-s <= 1) {
                    bw.write(0 + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
