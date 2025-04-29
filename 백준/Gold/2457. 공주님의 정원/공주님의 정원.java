import java.io.*;
import java.util.*;

public class Main {
    static int N, answer, sDay = 301, eDay = 1201, lastDay = 0;
    static int[][] flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        flowers = new int[N][2];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int sm = Integer.parseInt(stz.nextToken());
            int sd = Integer.parseInt(stz.nextToken());
            int em = Integer.parseInt(stz.nextToken());
            int ed = Integer.parseInt(stz.nextToken());

            flowers[i] = new int[] {sm*100+sd, em*100+ed};
        }


        // 시작하는 날 오름차순 - 끝나는 날 내림차순
        Arrays.sort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    if (o2[1] != o1[1]) {
                        return o2[1] - o1[1];
                    }
                }
                return 0;
            }
        });

        if (flowers[0][0] > sDay) {
            System.out.println(0);
            return;
        }

        int index = 0;

        // 시작날이 끝 날보다 빠를때만 성립가능함.
        // 시작날이 끝 날보다 늦으면 꽃을 이미 다 찾았으므로 반복문 종료.
        while(sDay < eDay) {
            // 꽃을 찾았는지 유무를 저장
            boolean isFinded = false;

            // index 부터 탐색 (초기값 0)
            // 꽃을 찾은 후 그 꽃 이후부터 탐색 i+1
            for(int i = index; i < N; i++) {
                // 시작날의 오름차순 정렬
                // 꽃이 피는 날이 시작날 보다 느리면 그 전까지는 시작날 보다 작은 꽃들
                // 꽃이 피는 날이 시작날 보다 느려지면 이 후 탐색은 의미가 없으므로 break
                if(flowers[i][0] > sDay) {
                    break;
                }

                // 저장된 꽃이 지는 날 보다 새로운 꽃이 지는 날이 느리면 새로운 꽃의 값 저장
                // 꽃이 지는 날 변경 (lastDay)
                // 이미 위에서 꽃이 피는날이 검증완료
                if(lastDay < flowers[i][1]) {
                    isFinded = true;
                    lastDay = flowers[i][1];
                    index = i + 1; // 현재까지 탐색한 꽃 다음부터 탐색하기 위한 값
                }
            }

            // 꽃을 찾았다면 다음 연결되는 꽃 찾기.
            // 기준 - 시작날을 최근 탐색한 꽃이 지는날로 저장. sDay - (시작날 = 꽃이 지는날 같은 상태)
            // 꽃을 찾지 못했다면 연결되는 꽃도 없기 때문에 반복문 종료.
            if(isFinded) {
                sDay = lastDay;
                answer++;
            } else {
                break;
            }
        }

        // 마지막 꽃이 지는 날이 끝 날 보다 빠르면 공백이 생기는 것 - 0을 출력
        // else - answer 출력 (꽃 개수)
        if(lastDay < eDay) {
            System.out.println(0);
        }
        else {
            System.out.println(answer);
        }

        br.close();
    }
}