import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt1 = Integer.parseInt(br.readLine());

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[cnt1];

        for(int i = 0; i < cnt1; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < cnt1; i++) {
            int num1 = arr[i];

            while(!stack.isEmpty()) {
                int num2 = arr[stack.peek()];
                if(num2 < num1) {
                    arr[stack.peek()] = num1;
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for(int i : arr) {
            sb.append(i + " ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}