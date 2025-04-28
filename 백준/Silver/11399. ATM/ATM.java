import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] arr, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];
        T = new int[N];

        stz = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        T[0] = arr[0];
        for (int i = 1; i < N; i++) {
            T[i] = arr[i] + T[i-1];
        }

        for (int t : T) {
            answer += t;
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }
}