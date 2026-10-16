
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum, sumSq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];

            update(1, 0, n - 1, prev + 1, i, 1);

            ans = (ans + sumSq[1]) % MOD;

            last[x] = i;
        }

        return (int) ans;
    }

    void apply(int node, int left, int right, long delta) {
        long len = right - left + 1L;

        sumSq[node] = (sumSq[node]
                + 2L * delta * sum[node]
                + delta * delta * len) % MOD;

        sum[node] = (sum[node] + delta * len) % MOD;
        lazy[node] += delta;
    }

    void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        long delta = lazy[node];

        apply(node * 2, left, mid, delta);
        apply(node * 2 + 1, mid + 1, right, delta);

        lazy[node] = 0;
    }

    void update(int node, int left, int right,
                int ql, int qr, long delta) {

        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, delta);
            return;
        }

        pushDown(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr, delta);
        update(node * 2 + 1, mid + 1, right, ql, qr, delta);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }
}
