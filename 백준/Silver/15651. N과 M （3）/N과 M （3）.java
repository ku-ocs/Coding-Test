import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        size = Integer.parseInt(stz.nextToken());

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

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            bt(n);
            stack.pop();

        }
    }
}

