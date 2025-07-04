    import java.io.*;
    import java.util.*;

    public class Main {
        static class Jewel implements Comparable<Jewel>{
            int mass;
            int value;

            Jewel(int mass, int value) {
                this.mass = mass;
                this.value = value;
            }


            @Override
            public int compareTo(Jewel o) {
                return this.mass - o.mass;
            }
        }

        static int N, K;
        static long answer;
        static int[] bags;
        static Jewel[] jewels;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(stz.nextToken());
            K = Integer.parseInt(stz.nextToken());

            jewels = new Jewel[N];
            bags = new int[K];

            for (int i = 0; i < N; i++) {
                stz = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(stz.nextToken());
                int v = Integer.parseInt(stz.nextToken());
                jewels[i] = new Jewel(m, v);
            }

            for (int i = 0; i < K; i++) {
                int bag = Integer.parseInt(br.readLine());
                bags[i] = bag;
            }

            Arrays.sort(jewels);
            Arrays.sort(bags);

            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            int jewelIdx = 0;
            for (int bag : bags) {
                while (jewelIdx < jewels.length && jewels[jewelIdx].mass <= bag) {
                    queue.offer(jewels[jewelIdx].value);
                    jewelIdx++;
                }

                // 가방에 들어갈 수 있는 물품들 중 가장 가치가 높은 것 - 가방 1개에 보석 1개
                // 가방은 오름차순으로 정렬되어 있기때문에 이미 queue 에 있는 보석들은 앞으로의 가방에 충분히 들어갈 수 있음.
                if (!queue.isEmpty()) {
                    answer += queue.poll();
                }
            }

            System.out.println(answer);

            br.close();
        }
    }
