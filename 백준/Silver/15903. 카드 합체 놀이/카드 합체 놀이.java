import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long answer;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        arr = new long[N];


        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(arr);
            long num1 = arr[0];
            long num2 = arr[1];

            arr[0] = num1+num2;
            arr[1] = num1+num2;
        }

        for (long i : arr) {
            answer += i;
        }

        System.out.println(answer);
    }
}
