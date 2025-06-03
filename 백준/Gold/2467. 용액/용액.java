import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, sum = Integer.MAX_VALUE;
    static int[] arr, answer = new int[2];
    static boolean isMinus, isPlus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stz.nextToken());
            arr[i] = num;
            if (!isMinus && num < 0) {
                isMinus = true;
            }
            if (!isPlus && num > 0) {
                isPlus = true;
            }
        }

        if (isMinus && !isPlus) {
            System.out.println(arr[N-2] + " " + arr[N-1]);
            return;
        }

        if (isPlus && !isMinus) {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }

        for (int i : arr) {
            int s = 0;
            int e = arr.length-1;
            if (sum == 0) {
                break;
            }

            while (s <= e) {
                int m = (s + e) / 2;
                int tempSum = i + arr[m];
                if (sum > Math.abs(tempSum)) {
                    if (i != arr[m]) {
                        answer[0] = i;
                        answer[1] = arr[m];
                        sum = Math.abs(tempSum);
                    }
                    if (tempSum > 0) {
                        e = m - 1;
                    } else if (tempSum < 0) {
                        s = m + 1;
                    } else {
                        break;
                    }
                } else {
                    if (tempSum > 0) {
                        e = m - 1;
                    } else{
                        s = m + 1;
                    }
                }
            }
        }

        Arrays.sort(answer);

        bw.write(answer[0] + " " + answer[1]);

        bw.flush();
        bw.close();
        br.close();
    }
}