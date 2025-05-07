import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt;
    static Queue<Integer> mQ = new LinkedList<>();
    static Queue<Integer> tQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        for (int i = 2; i <= N; i++) {
            mQ.offer(i);
        }

        while (!mQ.isEmpty()) {
            int num = mQ.peek();
            tQ.clear();
            for (int i : mQ) {
                if (i % num == 0) {
                    cnt++;
                    if (cnt == K) {
                        System.out.println(i);
                        return;
                    }
                    continue;
                }
                tQ.offer(i);
            }

            mQ.clear();
            for (int i : tQ) {
                mQ.offer(i);
            }
        }
    }
}
