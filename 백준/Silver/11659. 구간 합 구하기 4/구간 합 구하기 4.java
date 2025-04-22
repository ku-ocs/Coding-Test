import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int[] D = new int[n+1];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++){
            D[i] = D[i-1] + Integer.parseInt(stz.nextToken());
        }

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());

            bw.write(D[e] - D[s-1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}