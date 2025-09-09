package HPE;

import java.util.ArrayList;
import java.util.List;

public class ArrayReconstruction {
    static final int MOD = 1_000_000_007;

    public static List<Integer> arrayCount(List<Integer> n, List<Integer> m, List<Integer> totalCost) {
        int q = n.size();
        List<Integer> result = new ArrayList<>();

        for (int idx = 0; idx < q; idx++) {
            int N = n.get(idx);
            int M = m.get(idx);
            int K = totalCost.get(idx);

            long[][][] dp = new long[N + 1][M + 1][K + 1];

            // base case: first element, no increases yet
            for (int v = 1; v <= M; v++) {
                dp[1][v][0] = 1;
            }

            // fill dp
            for (int len = 2; len <= N; len++) {
                for (int max = 1; max <= M; max++) {
                    for (int cost = 0; cost <= K; cost++) {

                        // Case 1: pick ≤ max
                        dp[len][max][cost] = (dp[len][max][cost] + dp[len - 1][max][cost] * max) % MOD;

                        // Case 2: new maximum
                        if (cost > 0) {
                            for (int oldMax = 1; oldMax < max; oldMax++) {
                                dp[len][max][cost] = (dp[len][max][cost] + dp[len - 1][oldMax][cost - 1]) % MOD;
                            }
                        }
                    }
                }
            }

            long ans = 0;
            for (int max = 1; max <= M; max++) {
                ans = (ans + dp[N][max][K]) % MOD;
            }
            result.add((int) ans);
        }

        return result;
    }
}
