
class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here

        Arrays.sort(arr);
        int max = arr[N - 1];
        int[] hash = new int[max + 1];
        int len = hash.length;
        for (int i = 0; i < N; i++) {
            int start = arr[i];
            if (start < len && hash[start] <= 1) {
                for (int j = start; j < len; j = j + start) {
                    hash[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= len && hash[arr[i]] > 1)
                ans++;
        }
        return ans;
    }
}