    import java.io.*;
    import java.util.*;
    import java.util.stream.Collectors;

    public class Main {
        static int N, M;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(stz.nextToken());
            M = Integer.parseInt(stz.nextToken());

            HashMap<String, HashSet<String>> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String group = br.readLine();
                int t = Integer.parseInt(br.readLine());
                HashSet<String> set = new HashSet<>();
                for (int j = 0; j < t; j++) {
                    set.add(br.readLine());
                }
                map.put(group, set);
            }

            Set<String> keyset = map.keySet();

            for (int i = 0; i < M; i++) {
                String find = br.readLine();
                int type = Integer.parseInt(br.readLine());

                if (type == 1) {
                    for (String group : keyset) {
                        HashSet<String> set = map.get(group);
                        if (set.contains(find)) {
                            bw.write(group + "\n");
                            break;
                        }
                    }
                    continue;
                }
                for (String member : map.get(find).stream().sorted().collect(Collectors.toList())) {
                    bw.write(member + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }
