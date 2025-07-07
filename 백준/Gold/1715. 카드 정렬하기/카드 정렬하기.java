import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (pq.size() >= 2) {
            int deck1 = pq.poll();
            int deck2 = pq.poll();

            answer += deck1 + deck2;
            pq.offer(deck1 + deck2);
        }

        System.out.println(answer);
    }
}
