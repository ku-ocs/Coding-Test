import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());

        For:
        for (int i = 0; i < cnt; i++) {
            char[] cArr = br.readLine().toCharArray();
            stack.clear();

            for(char c : cArr) {
                if( c == ')') {
                    if(stack.isEmpty()) {
                        bw.write("NO\n");
                        continue For;
                    } else if (stack.pop() != '('){
                        bw.write("NO\n");
                        continue For;
                    }
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                bw.write("YES\n");
            }  else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}