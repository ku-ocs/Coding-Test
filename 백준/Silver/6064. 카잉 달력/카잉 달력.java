import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        for (int i = 0; i < T; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(stz.nextToken());
            int n = Integer.parseInt(stz.nextToken());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            int answer = -1;

            int max = m / gcp(m, n) * n;

            int j = 0;
            while (true) {
                int num1 = j*m+x;
                int num2 = num1 % n == 0 ? n : num1 % n;

                if (num1 > max) {
                    break;
                }

                if (num2 == y) {
                    answer = num1;
                    break;
                }
                j++;
            }

            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcp(int m, int n) {
        if (m % n == 0) return n;
        else return gcp(n, m % n);
    }
}