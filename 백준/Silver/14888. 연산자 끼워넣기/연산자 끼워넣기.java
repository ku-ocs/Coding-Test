import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, answer1 = Integer.MIN_VALUE, answer2 = Integer.MAX_VALUE;
    static int[] nums, ops;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());

        nums = new int[N];
        ops = new int[4];

        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stz.nextToken());
        }

        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(stz.nextToken());
            ops[i] = num;
        }

        bt(0);

        System.out.println(answer1);
        System.out.println(answer2);
    }

    public static void bt(int n) {
        if (n == N-1) {
            int idx = 1;
            int temp = nums[0];
            for (int i : stack) {
                if (i == 0) {
                    temp += nums[idx++];
                } else if( i == 1 ) {
                    temp -= nums[idx++];
                } else if( i == 2 ) {
                    temp *= nums[idx++];
                } else {
                    temp /= nums[idx++];
                }
            }
            answer1 = Math.max(answer1, temp);
            answer2 = Math.min(answer2, temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            ops[i] -= 1;
            stack.push(i);
            bt(n+1);
            stack.pop();
            ops[i] += 1;
        }
    }
}
