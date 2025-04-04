import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();


        char[] cArr = br.readLine().toCharArray();
        int answer = 0;

        for(int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '(') {
                stack.push(i);
            } else {
                int idx = stack.pop();
                boolean laser = (i - idx) == 1;
                if(laser) {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}