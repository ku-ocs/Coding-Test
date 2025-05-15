import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static long answer;
    static int[] arr, vis, sel = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        StringTokenizer stz;
        for (int i = 0; i < T; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stz.nextToken());
            answer = 0;
            arr = new int[n];
            vis = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(stz.nextToken());
            }

            Arrays.sort(arr);

            bt(0, 0);

            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bt(int s,int n) {
        if (s == 2) {
            answer += gcd(arr[sel[1]], arr[sel[0]]);
            return;
        }
        for (int i = n; i < arr.length; i++) {
            if (vis[i] == 1) {
                continue;
            }

            vis[i] = 1;
            sel[s] = i;
            bt(s+1, i+1);
            sel[s] = 0;
            vis[i] = 0;
        }
    }

    // 유클리드 호제법
    // n1 과 n2 의 최대공약수는 n2 와 n1 % n2 의 최대공약수와 같다.
    public static int gcd(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        } else {
            return gcd(n2, n1 % n2);
        }
    }
}
