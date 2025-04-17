import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int size;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        size = Integer.parseInt(stz.nextToken());

        arr = new int[n];

        stz = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        bt(0, n);

        bw.flush();

        bw.close();
        br.close();
    }

    public static void bt(int s, int n) throws IOException {
        if (stack.size() == size) {
            for (int i : stack) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = s; i < n; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            stack.push(arr[i]);
            bt(i, n);
            stack.pop();
        }
    }
}

