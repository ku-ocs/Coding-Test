import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static long answer;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            stz = new StringTokenizer(br.readLine(), " ");
            pq.clear();
            answer = 0;
            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(stz.nextToken()));
            }

            while (pq.size() > 1) {
                long f1 = pq.poll();
                long f2 = pq.poll();
                answer += f1 + f2;
                pq.offer(f1 + f2);
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}