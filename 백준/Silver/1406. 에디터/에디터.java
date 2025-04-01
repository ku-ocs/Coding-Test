import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        String str1 = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for(char c : str1.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> loc = list.listIterator(list.size());

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            stz = new StringTokenizer(br.readLine(), " ");

            switch (stz.nextToken()) {
                case "L":
                    if (loc.hasPrevious()) {
                        loc.previous();
                    }
                    break;
                case "D":
                    if (loc.hasNext()) {
                        loc.next();
                    }
                    break;
                case "B":
                    if(loc.hasPrevious()) {
                        loc.previous();
                        loc.remove();
                    }
                    break;
                case "P":
                    loc.add(stz.nextToken().charAt(0));
                    break;
                default:
            }
        }

        StringBuilder answer = new StringBuilder();

        for (char s : list) {
            answer.append(s);
        }

        System.out.println(answer);
    }
}