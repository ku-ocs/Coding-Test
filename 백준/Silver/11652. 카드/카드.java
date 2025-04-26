import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, cnt, maxCnt;
    static long answer, temp;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        temp = arr[0];

        for (long i : arr) {
            if(i == temp) {
                cnt++;
            } else {
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                    answer = temp;
                }
                temp = i;
                cnt = 1;
            }
        }

        if (maxCnt < cnt) {
            maxCnt = cnt;
            answer = temp;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}