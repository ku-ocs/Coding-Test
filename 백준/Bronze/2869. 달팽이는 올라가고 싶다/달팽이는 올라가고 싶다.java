import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long A, B, V, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        A = Long.parseLong(stz.nextToken());
        B = Long.parseLong(stz.nextToken());
        V = Long.parseLong(stz.nextToken());

        answer = (long) Math.ceil((double) (V - A) / (A - B)) + 1;
        System.out.println(answer);
    }
}