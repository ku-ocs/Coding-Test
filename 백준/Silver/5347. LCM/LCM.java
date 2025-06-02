import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            long n1 = Long.parseLong(stz.nextToken());
            long n2 = Long.parseLong(stz.nextToken());

            long mul = n1 * n2;
            long gcd = gcd(n1, n2);

            bw.write(mul / gcd + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static long gcd(long n1, long n2) {
        if (n1 % n2 != 0) return gcd(n2, n1 % n2);
        else return n2;
    }
}