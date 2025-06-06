import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double n1, n2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        n1 = Double.parseDouble(stz.nextToken());
        n2 = Double.parseDouble(stz.nextToken());

        int n = 2;
        int cnt = 1;
        while (true) {
            int num1 = (int) Math.ceil(n1 / n);
            int num2 = (int) Math.ceil(n2 / n);
            if (num1 != num2) {
                n *= 2;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}