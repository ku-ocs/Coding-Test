import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= size; i++) {
            int height = Integer.parseInt(stz.nextToken());

            while(!stack.isEmpty()) {
                int[] arr = stack.peek();
                if (height > arr[1]) {
                    stack.pop();
                } else {
                    break;
                }
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek()[0] + " ");
            }

            stack.push(new int[]{i, height});

        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}