import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }
        NextNum:
        for (int num : arr) {
            if (num == 1) {
                continue;
            }
            int max = (int) Math.sqrt(num);
            for (int i = 2; i <= max; i++) {
                if (num % i == 0) {
                    continue NextNum;
                }
            }
            answer++;
        }
        System.out.println(answer);
        br.close();
    }
}