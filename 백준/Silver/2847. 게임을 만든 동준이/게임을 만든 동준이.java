import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr[i] = Integer.parseInt(line);
        }

        for (int i = N-2; i >= 0; i--) {
            while (arr[i+1] <= arr[i]) {
                arr[i] -= 1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
