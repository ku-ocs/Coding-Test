import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        While:
        while(true) {
            String s = br.readLine();
            stack.clear();
            if (s.equals(".")) {
                break;
            }

            char[] cArr = s.toCharArray();
            for (char c : cArr) {
                switch (c) {
                    case '(':
                        stack.push(c);
                        break;
                    case '[' :
                        stack.push(c);
                        break;
                    case ')' :
                        if (stack.isEmpty() || stack.pop() != ('(')) {
                            bw.write("no\n");
                            continue While;
                        }
                        break;
                    case ']' :
                        if (stack.isEmpty() || stack.pop() != ('[')) {
                            bw.write("no\n");
                            continue While;
                        }
                        break;
                    case '.' :
                        if(stack.isEmpty()) {
                            bw.write("yes\n");
                        } else {
                            bw.write("no\n");
                        }
                    default:
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}