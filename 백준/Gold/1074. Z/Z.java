import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stz.nextToken());
        int r = Integer.parseInt(stz.nextToken());
        int c = Integer.parseInt(stz.nextToken());

        z((int) Math.pow(2, n), r, c);
    }

    public static void z(int size, int r, int c) {
        if(size == 1) {
            System.out.println(answer);
            return;
        }

        int half = size / 2;

        if (r < half && c < half) {
            z(half, r, c);
        }

        if (r < half && c >= half) {
            answer += half*half;
            z(half, r, c - half);
        }
        if (r >= half && c < half) {
            answer += half * half * 2;
            z(half, r - half, c);
        }
        if (r >= half && c >= half) {
            answer += half * half * 3;
            z(half, r - half, c - half);
        }
    }
}
