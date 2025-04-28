import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt, answer;
    static int[] ropes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        ropes = new int[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        cnt = 1;

        for (int i = N-1; i >= 0; i--) {
            int w = ropes[i]*cnt++;
            answer = Math.max(answer, w);
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }
}