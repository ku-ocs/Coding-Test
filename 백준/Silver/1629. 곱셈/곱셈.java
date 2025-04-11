import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(stz.nextToken());
        long b = Long.parseLong(stz.nextToken());
        long c = Long.parseLong(stz.nextToken());

        long answer = mod(a, b, c);

        System.out.println(answer);
    }

    public static long mod(long a,long b,long c) {
        if (a == 1 || b == 1) {
            return a % c;
        }

        long temp = mod(a, b/2, c);

        if ( b % 2 == 0) {
            return temp * temp % c;
        } else {
            return (temp * temp % c) * a % c;
        }
    }
}
