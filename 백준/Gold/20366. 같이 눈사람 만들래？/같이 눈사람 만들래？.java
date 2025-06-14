import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int snowman = arr[i] + arr[j];

                int s = i+1;
                int e = N-1;

                if (s == j) {
                    s++;
                }
                if (e == j) {
                    e--;
                }

                while (s < e) {
                    int otherSnowman = arr[s] + arr[e];
                    int gap = otherSnowman - snowman;
                    if (answer > Math.abs(gap)) {
                        answer = Math.abs(gap);
                    }

                    // gap 이 0이면 최소값이므로 break;
                    // gap 이 0보다 작으면 snowman 이 크다는 것 -> otherSnowman 의 값을 키우기 위해 s++;
                    // gap 이 0보다 크면 snowman 이 작다는 것 -> otherSnowman 의 값을 줄이기 위해 e--;
                    if (gap == 0) {
                        break;
                    } else if (gap < 0) {
                        s++;
                    } else {
                        e--;
                    }

                    if (s == j) {
                        s++;
                    }

                    if (e == j) {
                        e--;
                    }
                }
            }
        }

        System.out.println(answer);
    }


}
