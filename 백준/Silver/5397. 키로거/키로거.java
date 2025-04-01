import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            String str = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> loc = list.listIterator(0);

            char[] CharArr = str.toCharArray();

            for (char c : CharArr) {
                switch (c) {
                    case '<':
                        if (loc.hasPrevious()) {
                            loc.previous();
                        }
                        break;
                    case '>':
                        if (loc.hasNext()) {
                            loc.next();
                        }
                        break;
                    case '-':
                        if(loc.hasPrevious()) {
                            loc.previous();
                            loc.remove();
                        }
                        break;
                    default:
                        loc.add(c);
                }
            }

            for (char c : list) {
                answer.append(c);
            }

            if(i != num) {
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }
}