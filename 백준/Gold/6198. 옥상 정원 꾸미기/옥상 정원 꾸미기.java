import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        long count = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()) {
                if(stack.peek() <= height) {
                    stack.pop();
                } else {
                    break;
                }
            }
            
            stack.push(height);
            count += (stack.size() - 1);
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}