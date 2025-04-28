import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--) {
            answer += K / arr[i];
            K %= arr[i];
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}