import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Queue[] queues = new Queue[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int i = 1; i < N+1; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(stz.nextToken());
            String name = stz.nextToken();

            queues[age].offer(name);
        }

        for (int i = 1; i < queues.length; i++) {
            while(!queues[i].isEmpty()) {
                bw.write(i + " " + queues[i].poll() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}