import java.util.Arrays;

class Solution {
    int[] lexicographicallyLargest(int[] a, int n) {
        // Write your code here
        int s = 0; // start
        int e = -1; // end
        int[] result = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && (a[i] + a[i + 1]) % 2 == 0) {
                e = i + 1; // if it is true just keep increasing the range
            } else {
                if (e == -1) {
                    // single element
                    result[k++] = a[s];
                } else {
                    // multiple elements
                    int[] subArray = Arrays.copyOfRange(a, s, e + 1);
                    Arrays.sort(subArray);
                    for (int j = subArray.length - 1; j >= 0; j--) {
                        result[k++] = subArray[j];
                    }
                }
                s = i + 1;
                e = -1;
            }
        }
        return result;
    }
}