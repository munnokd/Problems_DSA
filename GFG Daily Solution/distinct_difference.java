//Problem of the day 19-03-2023

class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {

        // Finding the Left & Right Distinct Elements for each Index
        // Using kind of Prefix Sum

        int left = 1;
        int right = N - 2;
        int[] leftDistincts = new int[N];
        int[] rightDistincts = new int[N];
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();

        while (left < N && right >= 0) {

            leftSet.add(A[left - 1]);
            rightSet.add(A[right + 1]);

            leftDistincts[left] = leftSet.size();
            rightDistincts[right] = rightSet.size();

            left++;
            right--;
        }

        // Just Calculating the Difference of Left & Right Distinct Elements
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ans.add(leftDistincts[i] - rightDistincts[i]);
        }

        return ans;
    }
}
