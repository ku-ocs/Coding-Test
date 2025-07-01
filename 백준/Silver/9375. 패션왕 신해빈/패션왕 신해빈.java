    import java.io.*;
    import java.util.*;

    public class Main {
        static LinkedHashMap<String, Integer> map;
        static int T, N, answer;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer stz;
            T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                map = new LinkedHashMap<>();
                N = Integer.parseInt(br.readLine());
                answer = 1;

                for (int j = 0; j < N; j++) {
                    stz = new StringTokenizer(br.readLine(), " ");
                    String item = stz.nextToken(); // 필요 없음
                    String cate = stz.nextToken();
                    map.put(cate, map.getOrDefault(cate, 0) + 1);
                }

                for (int cnt : map.values()) {
                    answer *= (cnt + 1);
                }

                bw.write(answer-1 + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }
