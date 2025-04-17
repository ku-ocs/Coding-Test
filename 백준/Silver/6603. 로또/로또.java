import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, vis;
    static int size = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        while(true) {
            stz = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stz.nextToken());

            if (n == 0) {
                break;
            }

            arr = new int[n];
            vis = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stz.nextToken());
            }

            bt(0, n);
            bw.write("\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bt(int s, int n) throws IOException {
        if(stack.size() == size) {
            for(int i : stack) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = s; i < arr.length; i++) {
            if(vis[i] == 0) {
                vis[i] = 1;
                stack.push(arr[i]);
                bt(i+1, n);
                stack.pop();
                vis[i] = 0;
            }
        }
    }
}

