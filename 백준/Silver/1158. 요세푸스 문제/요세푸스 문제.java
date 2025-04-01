import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(stz.nextToken());
        int num2 = Integer.parseInt(stz.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder answer = new StringBuilder();

        int loc = num2 - 1;

        for(int i = 1; i <= num1; i++) {
            list.add(i);
        }

        answer.append("<");

        while (!list.isEmpty()) {
            answer.append(list.get(loc));
            list.remove(loc);

            if (!list.isEmpty()) {
                answer.append(", ");
            }

            loc += (num2 - 1);

            int size = list.size();

            while (!list.isEmpty() && loc >= size) {
                loc -= size;
            }
        }

        answer.append(">");

        System.out.println(answer);
    }
}