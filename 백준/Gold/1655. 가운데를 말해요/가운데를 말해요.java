import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxPq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (minPq.isEmpty() || num < minPq.peek()) {
                minPq.offer(num);
            } else {
                maxPq.offer(num);
            }

            if (minPq.size() - maxPq.size() > 1) {
                maxPq.offer(minPq.poll());
            } else if (minPq.size() < maxPq.size()) {
                minPq.offer(maxPq.poll());
            }

            bw.write(minPq.peek() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}