import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N, M;
    static TreeSet<Problem> tree = new TreeSet<>(), subTree;
    static HashMap<Integer, TreeSet<Problem>> map = new HashMap<>();
    static HashMap<Integer, Problem> pMap = new HashMap<>();

    static class Problem implements Comparable<Problem>{
        int no; // 문제 번호
        int difficulty; // 난이도
        int sort; // 알고리즘 분류

        Problem(int no, int difficulty, int sort) {
            this.no = no;
            this.difficulty = difficulty;
            this.sort = sort;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.difficulty == o.difficulty) {
                return this.no - o.no;
            }
            return this.difficulty - o.difficulty;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Problem problem = (Problem) o;
            return no == problem.no;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(no);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int no = Integer.parseInt(stz.nextToken());
            int difficulty = Integer.parseInt(stz.nextToken());
            int sort = Integer.parseInt(stz.nextToken());
            addProblem(new Problem(no, difficulty, sort));
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            String order = stz.nextToken();
            if (order.equals("recommend")) {
                int sort = Integer.parseInt(stz.nextToken());
                int num = Integer.parseInt(stz.nextToken());
                if (num == 1) {
                    bw.write(map.get(sort).last().no + "\n");
                } else {
                    bw.write(map.get(sort).first().no + "\n");
                }
            } else if (order.equals("recommend2")) {
                int num = Integer.parseInt(stz.nextToken());
                if (num == 1) {
                    bw.write(tree.last().no + "\n");
                } else {
                    bw.write(tree.first().no + "\n");
                }
            } else if (order.equals("recommend3")) {
                int num = Integer.parseInt(stz.nextToken());
                int difficulty = Integer.parseInt(stz.nextToken());
                if (num == 1) {
                    Problem p = tree.ceiling(new Problem(0, difficulty, 0));
                    if (p == null) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(p.no + "\n");
                    }
                } else {
                    Problem p = tree.floor(new Problem(0, difficulty, 0));
                    if (p == null) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(p.no + "\n");
                    }
                }
            } else if (order.equals("add")) {
                int no = Integer.parseInt(stz.nextToken());
                int difficulty = Integer.parseInt(stz.nextToken());
                int sort = Integer.parseInt(stz.nextToken());
                addProblem(new Problem(no, difficulty, sort));
            } else {
                int no = Integer.parseInt(stz.nextToken());
                Problem p = pMap.get(no);
                tree.remove(p);
                pMap.remove(no);
                subTree = map.get(p.sort);
                subTree.remove(p);
                map.put(p.sort, subTree);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void addProblem(Problem p) {
        tree.add(p);
        if (map.containsKey(p.sort)) {
            subTree = map.get(p.sort);
        } else {
            subTree = new TreeSet<>();
        }
        subTree.add(p);
        map.put(p.sort, subTree);
        pMap.put(p.no, p);
    }
}
