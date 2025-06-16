import java.io.*;

public class Main {
    static int N;
    static long[] arr = new long[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        int e = 0; // N의 자릿수 기록
        while (Math.pow(10, e+1) <= N) {
            e++;
        }

        for (int i = 0; i <= e; i++) {
            int divide = (int) Math.pow(10, i);
            int mul = N / (divide*10);
            int digit = N % (divide*10) / (divide);
            int mod = N % divide;

            if (i == 0) {
                for (int j = 0; j < 10; j++) {
                    if (j >= 1 && j <= digit) {
                        arr[j] += mul+1;
                    } else {
                        arr[j] += mul;
                    }
                }
            } else if (i == e) {
                for (int j = 1; j < digit; j++) {
                    arr[j] += divide;
                }
                arr[digit] += mod+1;
            } else {
                for (int j = 0; j < 10; j++) {
                    if (j >= 1 && j < digit) {
                        arr[j] += (mul+1) * divide;
                    } else {
                        arr[j] += mul * divide;
                    }
                }
                arr[digit] += mod+1;
                if (digit == 0) {
                    arr[digit] -= divide;
                }
            }

        }

        for (long l : arr) {
            bw.write(l + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
