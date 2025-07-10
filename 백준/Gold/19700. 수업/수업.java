import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = 0;

    static class Person implements Comparable<Person> {
        int height;
        int limit;

        Person(int height, int limit) {
            this.height = height;
            this.limit = limit;
        }


        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        N = Integer.parseInt(br.readLine());
        TreeSet<Person> tree = new TreeSet<>();
        TreeMap<Integer, Integer> group = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int height = Integer.parseInt(stz.nextToken());
            int limit = Integer.parseInt(stz.nextToken());
            Person p = new Person(height, limit);
            tree.add(p);
        }

        for (Person p : tree) {
            Integer g = group.lowerKey(p.limit);
            if (g == null) {
                group.put(1, group.getOrDefault(1, 0) + 1);
                answer++;
            } else {
                if (group.get(g) == 1) {
                    group.remove(g);
                } else {
                    group.put(g, group.get(g) - 1);
                }
                group.put(g+1, group.getOrDefault(g+1, 0) + 1);
            }
        }

        System.out.println(answer);
    }
}


