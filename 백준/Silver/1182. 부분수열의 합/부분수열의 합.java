import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, vis;
    static int sum = 0;
    static int answer = 0;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stz.nextToken());
        int s = Integer.parseInt(stz.nextToken());

        arr = new int[n];
        vis = new int[n];

        stz = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        bt(0, s);

        System.out.println(answer);
    }

    public static void bt(int s1, int s2) {
        if (sum == s2 && !stack.isEmpty()) {
            answer++;
        }

        for (int i = s1; i < arr.length; i++) {
            if(vis[i] == 0) {
                int s = arr[i];
                vis[i] = 1;
                sum += s;
                stack.push(s);
                bt(i+1, s2);
                stack.pop();
                sum -= s;
                vis[i] = 0;
            }
        }
    }
}

