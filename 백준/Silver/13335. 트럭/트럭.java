import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, W, L, l = 0, t = 0;
    static Queue<Integer> bq = new LinkedList<>(), tq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        W = Integer.parseInt(stz.nextToken());
        L = Integer.parseInt(stz.nextToken());

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tq.offer(Integer.parseInt(stz.nextToken()));
        }

        for (int i =0; i < W; i++) {
            bq.offer(0);
        }

        while (!bq.isEmpty()) {
            l -= bq.poll();
            if(!tq.isEmpty()) {
                int truck = tq.peek();
                if (L >= l + truck) {
                    bq.offer(truck);
                    l += truck;
                    tq.poll();
                } else {
                    bq.offer(0);
                }
            }
            t++;
        }

        bw.write(t + "");

        bw.flush();
        bw.close();
        br.close();
    }
}