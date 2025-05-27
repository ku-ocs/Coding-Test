import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long A, B, answer;
    static int sqrtB;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        A = Long.parseLong(stz.nextToken());
        B = Long.parseLong(stz.nextToken());

        sqrtB = (int) Math.sqrt(B); // sqrtB 의 수는 포함되어야함.
        arr = new boolean[sqrtB+1];
        Arrays.fill(arr, true);

        for (int i = 2; i <= sqrtB; i++) {
            if (!arr[i]) {
                continue;
            }
            int j = 1;
            while (true) {
                if(i*j > sqrtB) break;
                else arr[i*j++] = false;
            }
            int e = 2;
            while (true) {
                long num = (long) Math.pow(i, e++);
                if (num > B) break;
                if (num < A) continue;
                answer++;
            }
        }

        System.out.println(answer);
    }
}