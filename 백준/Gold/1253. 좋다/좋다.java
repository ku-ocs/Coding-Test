import java.io.*;
import java.util.Arrays;
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

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isGood(int idx) {
        next:
        for (int j = 0; j < N; j++) {
            if (j == idx) continue;
            int need = arr[idx] - arr[j];
            int s = 0;
            int e = arr.length-1;

            while (s <= e) {
                int m = (s + e) / 2;

                if (need == arr[m]) {
                    if (m != idx && m != j) return true;
                    // m 의 앞 뒤로 길게 탐색하여 arr[m] 과 값이 같고 m 이 idx, j 와 다른 m 찾기.
                    int fm = m;
                    int bm = m;
                    while (fm >= 0 && arr[m] == arr[fm]) {
                        if (fm != idx && fm != j) {
                            return true;
                        }
                        fm--;
                    }
                    while (bm < N && arr[m] == arr[bm]) {
                        if (bm != idx && bm != j) {
                            return true;
                        }
                        bm++;
                    }
                    continue next;
                } else if (need > arr[m]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }

        return false;
    }
}