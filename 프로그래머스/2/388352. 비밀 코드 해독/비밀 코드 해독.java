import java.util.*;

class Solution {
    static int answer;
    static Stack<Integer> stack = new Stack<>();
    public int solution(int n, int[][] q, int[] ans) {
        stack.clear();
        answer = 0;
        bt(1, n, q, ans);
        return answer;
    }

    public static void bt(int num, int n, int[][] q, int[] ans) {
        if (stack.size() == 5) {
            for (int i = 0; i < ans.length; i++) {
                int[] arr = q[i];
                int cnt = 0;
                int ansCnt = ans[i];

                for (int j : arr) {
                    if (stack.contains(j)) {
                        cnt++;
                    }
                }

                if (cnt != ansCnt) {
                    return;
                }
            }
            answer++;
            return;
        }

        for (int i = num; i <= n; i++) {
            stack.push(i);
            bt(i+1, n, q, ans);
            stack.pop();
        }
    }
}