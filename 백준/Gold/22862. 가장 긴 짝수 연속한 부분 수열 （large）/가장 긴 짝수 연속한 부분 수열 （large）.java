import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, s, e, odd, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        while (e < N) {
            if (arr[e] % 2 == 0) {
                e++;
            } else {
                getAnswer();
                odd++;
                e++;
                while (odd > K && s < N) {
                    if (arr[s++] % 2 != 0) {
                        odd--;
                    }
                }
            }
        }

        getAnswer();

        System.out.println(answer);
    }

    public static void getAnswer() {
        answer = Math.max(answer, e - s - odd);
    }
}