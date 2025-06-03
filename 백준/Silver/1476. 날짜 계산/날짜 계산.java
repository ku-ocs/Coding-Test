import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int E, S, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        E = Integer.parseInt(stz.nextToken());
        S = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        E = E == 15 ? 0 : E;
        M = M == 19 ? 0 : M;

        int i = 0;
        while (true) {
            answer = i*28 + S;
            if (answer % 15 == E && answer % 19 == M) {
                break;
            }
            i++;
        }

        System.out.println(answer);
    }
}