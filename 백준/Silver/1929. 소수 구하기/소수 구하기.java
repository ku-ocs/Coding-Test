import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] bool;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());

        bool = new boolean[e+1];
        Arrays.fill(bool, true);
        bool[1] = false;

        for (int i = 2; i <= e; i++) {
            if (!bool[i]) continue;
            for (int j = 2; i*j <= e; j++) {
                if (!bool[i*j]) continue;
                bool[i*j] = false;
            }
        }

        for(int i = s; i <= e; i++) {
            if (bool[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}