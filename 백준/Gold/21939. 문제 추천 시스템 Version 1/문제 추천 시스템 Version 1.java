import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static class Question implements Comparable<Question> {
        public int num;
        public int difficulty;

        Question(int num, int difficulty) {
            this.num = num;
            this.difficulty = difficulty;
        }


        @Override
        public int compareTo(Question o) {
            if (this.difficulty == o.difficulty) {
                return this.num - o.num;
            }
            return this.difficulty - o.difficulty;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeSet<Question> set = new TreeSet<>();
        HashMap<Integer, Question> map = new HashMap<>();
        StringTokenizer stz;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(stz.nextToken());
            int difficulty = Integer.parseInt(stz.nextToken());
            Question q = new Question(num, difficulty);
            set.add(q);
            map.put(num, q);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            String order = stz.nextToken();
            if (order.equals("add")) {
                int num = Integer.parseInt(stz.nextToken());
                int difficulty = Integer.parseInt(stz.nextToken());
                Question q = new Question(num, difficulty);
                set.add(q);
                map.put(num, q);
            } else if (order.equals("recommend")) {
                int recommend = Integer.parseInt(stz.nextToken());
                if (recommend == 1) {
                    bw.write(set.last().num + "\n");
                } else {
                    bw.write(set.first().num + "\n");
                }
            } else {
                int num = Integer.parseInt(stz.nextToken());
                if (map.containsKey(num)) {
                    set.remove(map.get(num));
                    map.remove(num);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
