import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(stz.nextToken());
        int end = Integer.parseInt(stz.nextToken());

        if (start == end) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] arr = new int[100001];
        int[] vis = new int[100001];
        vis[start] = 1;

        while(!queue.isEmpty()) {
            int pos = queue.poll();
            int cnt = arr[pos] + 1;

            if(pos + 1 <= 100000) {
                if (pos + 1 == end) {
                    System.out.println(cnt);
                    break;
                }

                if (vis[pos + 1] != 1) {
                    arr[pos + 1] = cnt;
                    vis[pos + 1] = 1;
                    queue.add(pos + 1);
                }

            }

            if(pos - 1 >= 0) {
                if (pos - 1 == end) {
                    System.out.println(cnt);
                    break;
                }

                if (vis[pos - 1] != 1) {
                    arr[pos - 1] = cnt;
                    vis[pos - 1] = 1;
                    queue.add(pos - 1);
                }
            }

            if(pos * 2 <= 100000) {
                if (pos * 2 == end) {
                    System.out.println(cnt);
                    break;
                }

                if (vis[pos * 2] != 1) {
                    arr[pos * 2] = cnt;
                    vis[pos * 2] = 1;
                    queue.add(pos * 2);
                }
            }
        }
    }
}
