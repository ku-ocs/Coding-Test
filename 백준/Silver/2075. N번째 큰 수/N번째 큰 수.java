import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            while (stz.hasMoreTokens()) {
                int num = Integer.parseInt(stz.nextToken());
                if (pq.size() == N) {
                    int qNum = pq.peek();
                    if (num > qNum) {
                        pq.poll();
                        pq.offer(num);
                    }
                } else {
                    pq.offer(num);

                }
            }
        }

        System.out.println(pq.poll());
    }
}
