import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static int T;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.fill(arr, 1);
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] == 0) continue;
            for (int j = 2; j*i < arr.length; j++) {
                arr[i*j] = 0;
            }
        }

        arr = IntStream.rangeClosed(2, 100000).filter(i -> arr[i] == 1).toArray();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j : arr) {
                int cnt = 0;
                while (num % j == 0) {
                    num /= j;
                    cnt++;
                }
                if (cnt > 0) {
                    bw.write(j + " " + cnt + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}