import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long T, dist, cnt, mv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        for (int i = 0; i < T; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            long s = Integer.parseInt(stz.nextToken());
            long e = Integer.parseInt(stz.nextToken());

            dist = e - s;
            cnt = 0;
            mv = 0;

            while (dist > 0) {
                mv++;
                dist -= 2 * mv;
                cnt += 2;
            }

            if (dist + mv <= 0) {
                cnt--;
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}