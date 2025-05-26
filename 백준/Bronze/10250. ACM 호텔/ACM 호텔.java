import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T, H, W, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        next:
        for (int i = 0; i < T; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(stz.nextToken());
            W = Integer.parseInt(stz.nextToken());
            N = Integer.parseInt(stz.nextToken());

            int cnt = 1;

            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    if (cnt == N) {
                        String s = String.valueOf(j);
                        if (s.length() < 2) {
                            s = "0" + s;
                        }

                        bw.write(k + "" + s + "\n");
                        continue next;
                    }
                    cnt++;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}