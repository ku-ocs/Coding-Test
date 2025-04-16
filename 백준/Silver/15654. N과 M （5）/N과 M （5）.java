import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int size;
    static int[] arr, vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        size = Integer.parseInt(stz.nextToken());

        arr = new int[n];
        vis = new int[n];

        stz = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        bt(n);

        bw.flush();

        bw.close();
        br.close();
    }

    public static void bt(int n) throws IOException {
        if (stack.size() == size) {
            for (int i : stack) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                stack.push(arr[i]);
                bt(n);
                stack.pop();
                vis[i] = 0;
            }
        }
    }
}

